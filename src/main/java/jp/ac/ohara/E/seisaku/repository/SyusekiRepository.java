package jp.ac.ohara.E.seisaku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.E.seisaku.model.SyusekiHyou;

@Repository
public interface SyusekiRepository  extends JpaRepository<SyusekiHyou, Long>{

}