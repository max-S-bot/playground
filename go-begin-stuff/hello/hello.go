package main

import (
    "fmt"
	"log"
    "example.com/greetings"
)

func main() {
    log.SetPrefix("greetings: ")
    log.SetFlags(0)
	msgs, err := greetings.Hellos([]string{"Gladys", "Chuck", "Bob"})
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(msgs)
} 