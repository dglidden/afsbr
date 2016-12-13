package com.illusionary

/**
 * User: dglidden
 * Date: 12/12/16
 */
class EmailClient {

    def sendEmail(def to, def author, def title, def created, def url) {
        println "Hey, I'm sending an email to ${to} about ${author}'s possible sale here: ${url}\n"

    }
}
