package com.narratage.rental.util

class EventUtil {

    def static keyEvent(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        def key = br.readLine()
        return key.isNumber() ? key = Integer.parseInt(key) : key
    }
}