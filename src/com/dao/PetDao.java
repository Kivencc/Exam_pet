package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.IPetDao;
import com.entity.Pet;

public class PetDao extends BaseDao implements IPetDao{
	public boolean nameExist(Pet pet){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet set=null;
		try {
			conn=getConnection();
			String sql="select * from pet where typename=?";
			st=conn.prepareStatement(sql);
			st.setObject(1, pet.getTypename());
			set=st.executeQuery();
			if(set.next()){
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(set, st, conn);
		}
		return flag;
	}

	public List<Pet> getAllPetType(Pet pet){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet set=null;
		ArrayList<Pet> list=new ArrayList<Pet>();
		try {
			conn=getConnection();
			String sql="select * from pet";
			st=conn.prepareStatement(sql);
			set=st.executeQuery();
			while (set.next()){
				int id=set.getInt("id");
				String typename=set.getString("typename");
				String petname=set.getString("petname");
				Pet p=new Pet(id, typename, petname);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(set, st, conn);
		}
		return list;
	}

	public int addPetType(Pet pet){
		String sql="insert into pet (typename,petname) values (?,?)";
		Object[] params={pet.getTypename(),pet.getPetname()};
		return executeUpdate(sql, params);
	}
	

	public List<Pet> getPetByKey(){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet set=null;
		ArrayList<Pet> list=new ArrayList<Pet>();
		try {
			conn=getConnection();
			String sql="select * from pet where petname like '%pet%'";
			st=conn.prepareStatement(sql);
			set=st.executeQuery();
			while(set.next()){
				int id=set.getInt("id");
				String typename=set.getString("typename");
				String petname=set.getString("petname");
				Pet p=new Pet(id, typename, petname);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(set, st, conn);
		}
		return list;
	}
	
	public List<Pet> getPetByPage(int pageno,int pagesize){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet set=null;
		ArrayList<Pet> list=new ArrayList<Pet>();
		try {
			conn=getConnection();
			String sql="select * from pet where petname like '%pet%' limit ?,?";
			st=conn.prepareStatement(sql);
			st.setObject(1,(pageno-1)*pagesize);
			st.setObject(2, pagesize);
			set=st.executeQuery();
			while (set.next()){
				int id=set.getInt("id");
				String typename=set.getString("typename");
				String petname=set.getString("petname");
				Pet p=new Pet(id, typename, petname);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(set, st, conn);
		}
		return list;
	}
}
