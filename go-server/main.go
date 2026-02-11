package main

import (
	"net/http"
	//"log"
	"fmt"
)

func main() {
	http.Handle("/", http.FileServer(http.Dir("/home/mxz-schwarz")))
	/*http.HandleFunc("playground", func(w http.ResponseWriter, r *http.Request) {
		//fmt.Println(w)
		//fmt.Println(r)
		fmt.Println("bar")
		log.Println("bar")
	})*/
	fmt.Println("starting server")
	http.ListenAndServe(":8000", nil)
}