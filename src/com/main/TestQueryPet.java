package com.main;

import java.util.List;
import java.util.Scanner;

import com.dao.PetDao;
import com.entity.Pet;

public class TestQueryPet {
	public static void main(String[] args) {
		PetDao pd=new PetDao();
		List<Pet> list=pd.getPetByKey();
		System.out.println("��ѯ������£�");
		for(Pet a:list){
			System.out.println("id:"+a.getId()+"\t�������ͣ�"+a.getTypename()+"\t�������֣�"+a.getPetname());
		}
		Scanner s=new Scanner(System.in);
		System.out.println("���������ݷ�һҳ�������룺");
		int pagesize=s.nextInt();
		System.out.println("��ѯ�ڼ�ҳ���ݣ������룺");
		int pageno=s.nextInt();
		List<Pet> list2=pd.getPetByPage(pageno, pagesize);
		for(Pet a:list2){
			System.out.println("id:"+a.getId()+"\t�������ͣ�"+a.getTypename()+"\t�������֣�"+a.getPetname());
		}
	}
}
