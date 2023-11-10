package dmacc.repo;

//@author valei - vlunderwood CIS175 - Fall 2023 Nov 02, 2023

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Menu;



@Repository
public interface IMenuRepo extends JpaRepository<Menu, Long>{

	
		
}