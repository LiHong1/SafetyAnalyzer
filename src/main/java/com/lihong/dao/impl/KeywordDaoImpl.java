package com.lihong.dao.impl;
import com.lihong.bean.Keyword;
import com.lihong.common.daoImpl.BaseDaoImpl;
import com.lihong.common.util.PinyinUtil;
import com.lihong.dao.KeywordDao;
/**
 * 关键字类
 * @author lihong2-ext
 *
 */
public class KeywordDaoImpl extends BaseDaoImpl<Keyword> implements KeywordDao {

	public KeywordDaoImpl() {
		super(KeywordDao.class);
	}

	/**
	 * 增加对象
	 */
	public void add(Keyword k) {
		k.setPinyin(PinyinUtil.str2Pinyin(k.getWord(),null));
		this.getSqlSession().insert(this.getMethodPath("add"),k);
	}

	public Keyword getByWord(String string) {
		return this.getSqlSession().selectOne(this.getMethodPath("getByWord"),string);
	}
}
