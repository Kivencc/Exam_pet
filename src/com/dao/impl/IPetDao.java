package com.dao.impl;

import java.util.List;

import com.entity.Pet;

public interface IPetDao {
	/**
	 * 判断宠物类型名称是否重复
	 * @param pet
	 * @return
	 */
	public boolean nameExist(Pet pet);
	/**
	 * 获取所有的宠物类型
	 * @param pet
	 * @return
	 */
	public List<Pet> getAllPetType(Pet pet);
	
	/**
	 * 新增宠物类型
	 * @param pet
	 * @return
	 */
	public int addPetType(Pet pet);
	
	/**
	 * 获取宠物名字带“pet”的所有宠物集合
	 * @param n
	 * @return
	 */
	public List<Pet> getPetByKey();
	
	/**
	 * 查询出名字带“pet”的记录 并分页
	 * @param pageno 第几页
	 * @param pagesize 分几页
	 * @return
	 */
	public List<Pet> getPetByPage(int pageno,int pagesize);
}
