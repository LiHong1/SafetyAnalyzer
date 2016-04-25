(function($) {
	$.fn.processResult = function(data) {
		var timeline = this.appendTo; 
		data = data.data;  
		for (var i = 0; i < data.length; i++) {
			var content;
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
						+ "<span class='vertical-date'>" + 今天 < br > "<small>"
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
	};

})(jQuery);