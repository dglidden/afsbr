package com.illusionary

/**
 * User: dglidden
 * Date: 12/12/16
 */
class AnimeFigureSaleBot {

    def main() {
        println 'Processing...'

        def fullname = 't3_5i0zso'
        // def fullname = ''

        // Get JSON
        def json = new RedditClient().retrieveJson(fullname)
        // println json

        json.data.children.each { it ->
            // println "Data: ${it}\n"

            // Scan through JSON for [SALE] entries
            def title = it['data']['title']
            def author = it['data']['author']
            def name = it['data']['name']
            def url = "https://www.reddit.com${it['data']['permalink']}"
            def created = new Date(it['data']['created'].longValue() * 1000)
            def isSale = (title ==~ /(?i).*sale.*/)

            println "Author: ${author}, Title: ${title}, Created: ${created}, Name: ${name}, URL: ${url}\n"

            if(isSale) {
                println "${author} might be selling something!\n"
                // Send email if you find one
                new EmailClient().sendEmail('dglidden@gmail.com', author, title, created, url)
            }
        }

        // need to figure out how to store the "last one checked" somehow
    }
}
