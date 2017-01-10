package com.main;

import java.util.List;
import java.util.Scanner;

import com.dao.PetDao;
import com.entity.Pet;

public class TestAddPetType {
	public static void main(String[] args) {
		System.out.println("********宠物宠物类型*******");
		Scanner s=new Scanner(System.in);
		System.out.println("请输入宠物类型名称：");
		String typename=s.next();
		System.out.println("请输入该宠物名字：");
		String petname=s.next();
		Pet pet=new Pet();
		pet.setTypename(typename);
		pet.setPetname(petname);
		PetDao pd=new PetDao();
		if(pd.nameExist(pet)){
			System.out.println("宠物类型名称存在！");
		}else{
			int i=pd.addPetType(pet);
			if(i>0){
				System.out.println("宠物类型新增成功！");
				System.out.println("宠物类型列表如下：");
				List<Pet> list=pd.getAllPetType(pet);
				for(Pet a:list){
					System.out.println("id:"+a.getId()+"\t宠物类型："+a.getTypename()+"\t宠物名字："+a.getPetname());
				}
			}else{
				System.out.println("宠物类型新增失败！");
			}
		}
	}
}
