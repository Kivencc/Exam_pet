package com.main;

import java.util.List;
import java.util.Scanner;

import com.dao.PetDao;
import com.entity.Pet;

public class TestQueryPet {
	public static void main(String[] args) {
		PetDao pd=new PetDao();
		List<Pet> list=pd.getPetByKey();
		System.out.println("查询结果如下：");
		for(Pet a:list){
			System.out.println("id:"+a.getId()+"\t宠物类型："+a.getTypename()+"\t宠物名字："+a.getPetname());
		}
		Scanner s=new Scanner(System.in);
		System.out.println("多少条数据分一页？请输入：");
		int pagesize=s.nextInt();
		System.out.println("查询第几页数据？请输入：");
		int pageno=s.nextInt();
		List<Pet> list2=pd.getPetByPage(pageno, pagesize);
		for(Pet a:list2){
			System.out.println("id:"+a.getId()+"\t宠物类型："+a.getTypename()+"\t宠物名字："+a.getPetname());
		}
	}
}
