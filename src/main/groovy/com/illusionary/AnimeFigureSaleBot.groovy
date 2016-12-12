package com.illusionary

import groovy.json.JsonSlurper

/**
 * User: dglidden
 * Date: 12/12/16
 */
class AnimeFigureSaleBot {

    def main() {
        println "Hello, world!"

        def name = 't3_5hqsle'

        // Get JSON
        def json = new RedditClient().retrieveJson(name)
        // println json

        json.data.children.each { it ->
            // println "Data: ${it}\n"

            // Scan through JSON for [SALE] entries
            def title = it['data']['title']
            def author = it['data']['author']
            def currentName = it['data']['name']
            def isSale = (title ==~ /(?i).*sale.*/)

            println "Author: ${author}, Title: ${title}, Name: ${currentName}\n"

            if(isSale) {
                println "${author} might be selling something!\n"
                // Send email if you find one
            }
        }

        // need to figure out how to store the "last one checked" somehow
    }
}
