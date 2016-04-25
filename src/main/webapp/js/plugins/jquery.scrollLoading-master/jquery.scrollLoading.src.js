;(function($){
    var $scrollLoading;
    $.fn.scrollLoading = function(settings){
        return this.each(function(){
            $scrollLoading.init($(this), settings);
        });
    };

    $scrollLoading = $.scrollLoading = {
        more: true,
  
        init: function(outer, settings) {
        	this.count = 0;
            // objects
            this.outer = outer;
            this.appendTo = settings.appendTo;
            this.size = settings.size;
            this.judgeBy = settings.appendTo || this.appendTo;
            this.ratio = settings.ratio || 0.9;
            // ajax settings
            this.ajaxData = settings.ajaxData || {};

            // overwrite datType
            if ('undefined' === typeof this.ajaxData.dataType || !$.inArray(this.ajaxData.dataType, ('html', 'json'))) {
                this.ajaxData.dataType = 'html';
            }

            // overwrite success callback function
            this.tmp_success = this.ajaxData.success;
            this.ajaxData.success = function(ret) {
                sl = $scrollLoading;
                sl.processResult(ret);
                //sl.more = true;
                // 若需要有更新 data 的動作要寫在 success 裡
                if ('function' === typeof sl.tmp_success) {
                    sl.tmp_success(ret);
                }

                // 檢查版面高度夠不夠讓捲軸出現
                if (sl.more) {
                    sl.checkGetMore();
                }
            };
            this.outer.scroll(function(){
                var sl = $scrollLoading;
                var scrollBottom = sl.outer.scrollTop() + $(window).height();
                if ((true === sl.more) && (scrollBottom / sl.judgeBy.height() >= sl.ratio)) {
                    sl.more = false;
                    $("#loading").show();
                    sl.sendRequest();
                }
            });

            // 檢查版面高度夠不夠讓捲軸出現
            this.checkGetMore();
        },

        sendRequest: function() {
        	$.extend(this.ajaxData.data,{"beginPosition":this.count*this.size,"size":this.size});
            $.ajax(this.ajaxData);
        },

        checkGetMore: function() {
            if (this.judgeBy.height() < this.outer.height() * 0.8) {
                this.more = false;
                this.sendRequest();
            }
        },

        resultHandler: function(ret) {
            var content = '';
            if ('html' === this.ajaxData.dataType) {
                content = ret;
            } else if ('json' === this.ajaxData.dataType) {
                if (true === ret.error) {
                    content = '';
                } else if ('undefined' !== typeof ret.content) {
                    content = ret.content;
                }
            }

            if ('' !== content) {
                this.appendTo.append(content);
                this.more = true;
            }
        },
        processResult : function(data) {
    		var timeline = this.appendTo; 
    		data = data.data;  
    		if (data.length>0){
        		this.count++;
        		 this.more = true;
        	}
    		$("#loading").hide();
    		for (var i = 0; i < data.length; i++) {
    			var content;
    			sl.more = true;
    			if (data[i].type == 1 || data[i].type == '1') {  
    				content = "<div class='vertical-timeline-block'>"
    						+ "<div class='vertical-timeline-icon blue-bg'>"
    						+ "<i class='fa fa-file-text'></i>"
    						+ "</div>"
    						+ "<div class='vertical-timeline-content'>"
    						+ "<h2>短信</h2>"
    						+ "<p><span>短信内容： </span>"
    						+ data[i].content
    						+ "</p>"
    						+ "<a href='timeline_v2.html#' class='btn btn-sm btn-primary'> 更多信息</a>"
    						+ "<span class='vertical-date'>今天 < br > <small>"
    						+ data[i].createdDate + "</small>" + "</span>"
    						+ "</div>" + "</div>";
    			} else {
    				content = "<div class='vertical-timeline-block'>"
    						+ "<div class='vertical-timeline-icon yellow-bg'>"
    						+ "<i class='fa fa-phone'></i>"
    						+ "</div>"
    						+ "<div class='vertical-timeline-content'>"
    						+ "<h2>來自"
    						+ data[i].strangePhone
    						+ "的电话</h2>"  
    						+ "<p><span>解析内容： </span>"
    						+ data[i].content
    						+ "</p>"
    						+ "<a href='timeline_v2.html#' class='btn btn-sm btn-info'>更多信息</a>"
    						+ "<span class='vertical-date'>昨天 <br><small>"
    						+ data[i].createdDate + "</small></span>" + "</div>"
    						+ "</div>";
    			}

    			timeline.append(content);
    		};
    	}
    };
    
    
;

})(jQuery);
