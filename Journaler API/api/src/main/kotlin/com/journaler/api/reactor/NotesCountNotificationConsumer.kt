package com.journaler.api.reactor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.bus.Event

@Service
class NotesCountNotificationConsumer : NotificationConsumer<NotesCountNotification> {

    @Autowired
    lateinit var service: NotesCountNotificationService

    override fun accept(e: Event<NotesCountNotification>?) {
        val data = e?.data
        data?.let {
            service.notify(data)
        }
    }

}