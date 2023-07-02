Usage:
1. Returns word count:
curl http://localhost:8080/wordcounter?word=test
2, Adds words:
curl -d "word=test" -X POST http://localhost:8080/wordcounter?word=test