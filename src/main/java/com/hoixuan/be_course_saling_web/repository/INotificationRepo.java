package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface INotificationRepo extends CrudRepository<Notification,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM course_saling_web.notification where status=false order by time_notification desc limit 5;")
    List<Notification> getNotificationNew();
}
