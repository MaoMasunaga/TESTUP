package jp.ac.ohara.E.seisaku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.E.seisaku.model.SeisekiHyou;
import jp.ac.ohara.E.seisaku.repository.SeisekiRepository;
 

@Service
@Transactional
public class  SeisekiService{

    @Autowired
    private SeisekiRepository repository;

    /**
     * 学生一覧の取得
     * @return List<Seiseki>
     */
    
    public List<SeisekiHyou> getGakuseiList() {
        List<SeisekiHyou> entityList = this.repository.findAll();
        return entityList;
    }
    /**
     * 詳細データの取得
     * @param @NonNull Long index

     */
    public SeisekiHyou get(@NonNull Long index) {
        SeisekiHyou seiseki = this.repository.findById(index).orElse(new SeisekiHyou());
        return seiseki;
    }

    public void save(@NonNull SeisekiHyou seiseki) {
        this.repository.save(seiseki);
    }

    /**
     * アドレス帳データの削除
     * @param @NonNull Long index
     */
    public void delete(@NonNull Long index) {
        this.repository.deleteById(index);
    }
}