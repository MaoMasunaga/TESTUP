package jp.ac.ohara.E.seisaku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.E.seisaku.model.SyusekiHyou;
import jp.ac.ohara.E.seisaku.repository.SyusekiRepository;
 

@Service
@Transactional
public class  SyusekiService{

    @Autowired
    private SyusekiRepository repository;

    /**
     * 学生一覧の取得
     * @return List<Gakusei>
     */
    public List<SyusekiHyou> getGakuseiList() {
        List<SyusekiHyou> entityList = this.repository.findAll();
        return entityList;
    }

    /**
     * 詳細データの取得
     * @param @NonNull Long index

     */
    public SyusekiHyou get(@NonNull Long index) {
        SyusekiHyou gakusei = this.repository.findById(index).orElse(new SyusekiHyou());
        return gakusei;
    }

    public void save(@NonNull SyusekiHyou syuseki) {
        this.repository.save(syuseki);
    }

    /**
     * アドレス帳データの削除
     * @param @NonNull Long index
     */
    public void delete(@NonNull Long index) {
        this.repository.deleteById(index);
    }
}