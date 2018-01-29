package com.ridvan.daily2.repository;

import com.ridvan.daily2.model.Entry;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public interface EntryRepository extends CrudRepository<Entry, Integer> {

    @Query("SELECT e from Entry e")
    List<Entry> findAllEntries();

    @Query("SELECT e from Entry e where id=:id")
    Entry findEntryByById(@Param("id") Integer id);

    @Modifying
    @Query("DELETE from Entry e where id=:id")
    void deleteEntryById(@Param("id") Integer id);


    @Query("SELECT e from Entry e where title like CONCAT('%',:keyword,'%')")
    List<Entry>  filterTitleByKeyword(@Param("keyword") String keyword);

}
