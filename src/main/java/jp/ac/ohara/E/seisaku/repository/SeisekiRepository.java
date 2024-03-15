package jp.ac.ohara.E.seisaku.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.E.seisaku.model.SeisekiHyou;

@Repository
public interface SeisekiRepository  extends JpaRepository<SeisekiHyou, Long>{
	List<SeisekiHyou> findAllByStudentnumberEquals(String studentnumber);
	

}