package com.dolmit.pakiautomaat;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PakiautomaatRepo extends JpaRepository<Pakiautomaat, Long> {
	
	@Query("SELECT s FROM Pakiautomaat s WHERE active=?1 and skoor=?2")
	List<Pakiautomaat> findByActiveAndScore(boolean active, int skoor);
	
	@Query("SELECT s FROM Pakiautomaat s WHERE ((openfrom<=8 and closedfrom>=17)) or (closedfrom-openfrom)=0")
	List<Pakiautomaat> findOpenOnBusinsesHours();
	
	@Query("SELECT s FROM Pakiautomaat s WHERE (((closedfrom-openfrom)/10)>=1 or (closedfrom-openfrom)=0) or ((closedfrom-openfrom)/10)<=-1")
	List<Pakiautomaat> findOpen10h();
}