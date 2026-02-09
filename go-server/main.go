package main

import (
	"net/http"
	"fmt"
)

func main() {
	fmt.Println("starting server")
	http.HandleFunc("", func(w http.ResponseWriter, r *http.Request) {

	})
	http.ListenAndServe(":8000", http.FileServer(http.Dir("go-server")))
}