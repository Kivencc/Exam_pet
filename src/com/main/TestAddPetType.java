package com.main;

import java.util.List;
import java.util.Scanner;

import com.dao.PetDao;
import com.entity.Pet;

public class TestAddPetType {
	public static void main(String[] args) {
		System.out.println("********�����������*******");
		Scanner s=new Scanner(System.in);
		System.out.println("����������������ƣ�");
		String typename=s.next();
		System.out.println("������ó������֣�");
		String petname=s.next();
		Pet pet=new Pet();
		pet.setTypename(typename);
		pet.setPetname(petname);
		PetDao pd=new PetDao();
		if(pd.nameExist(pet)){
			System.out.println("�����������ƴ��ڣ�");
		}else{
			int i=pd.addPetType(pet);
			if(i>0){
				System.out.println("�������������ɹ���");
				System.out.println("���������б����£�");
				List<Pet> list=pd.getAllPetType(pet);
				for(Pet a:list){
					System.out.println("id:"+a.getId()+"\t�������ͣ�"+a.getTypename()+"\t�������֣�"+a.getPetname());
				}
			}else{
				System.out.println("������������ʧ�ܣ�");
			}
		}
	}
}
