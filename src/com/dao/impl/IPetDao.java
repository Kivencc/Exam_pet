package com.dao.impl;

import java.util.List;

import com.entity.Pet;

public interface IPetDao {
	/**
	 * �жϳ������������Ƿ��ظ�
	 * @param pet
	 * @return
	 */
	public boolean nameExist(Pet pet);
	/**
	 * ��ȡ���еĳ�������
	 * @param pet
	 * @return
	 */
	public List<Pet> getAllPetType(Pet pet);
	
	/**
	 * ������������
	 * @param pet
	 * @return
	 */
	public int addPetType(Pet pet);
	
	/**
	 * ��ȡ�������ִ���pet�������г��Ｏ��
	 * @param n
	 * @return
	 */
	public List<Pet> getPetByKey();
	
	/**
	 * ��ѯ�����ִ���pet���ļ�¼ ����ҳ
	 * @param pageno �ڼ�ҳ
	 * @param pagesize �ּ�ҳ
	 * @return
	 */
	public List<Pet> getPetByPage(int pageno,int pagesize);
}
