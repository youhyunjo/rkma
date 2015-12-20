
rkma : R Korean Morphological Analyzer. An R interface to KKMA version 2.0.

- [KKMA](https://github.com/konlpy/kkma) is an open source Java libarary for
  Korean NLP: morphological analysis, sentence segmentation, part-of-speech
  tagging and keyword extraction.
- [KoNLP](https://github.com/haven-jeon/KoNLP) provides an R interface to the
  HanNanum Korean morphological analyzer and POS tagger.
- [KoNLPy](https://github.com/konlpy/konlpy) provides Python bindings to
  several Korean morphological analyzers: KKMA, HanNanum, KOMORAN, mecab-ko
  and korean-twitter-text.


## Installation

```
install.packages("devtools")
library(devtools)
install_github("youhyunjo/rkma")
```


## Usage

```
> rkma::tag("안녕하세요. 형태소분석기를 사용해보세요.")
 [1] "안녕/NNG"   "하/XSV"     "세요/EFN"   "./SF"       "형태소/NNG"
 [6] "분석기/NNG" "를/JKO"     "사용하/VV"  "어/ECS"     "보/VXV"    
[11] "세요/EFN"   "./SF"
```





## Bindings to rkma Java Objects

This R package contains a Java package `rkma` that provides wrappers for kkma
objects.


### RMorphemeAnalyzer

```
text <- "안녕하세요. 형태소분석기를 사용해보세요."
rma <- new(RMorphemeAnalyzer)
rsentlst <- rma$analyze()      ## RSentenceList
```

```
> rsentlst$toMorphStringArray()
 [1] "안녕/NNG"   "하/XSV"     "세요/EFN"   "./SF"       "형태소/NNG"
 [6] "분석기/NNG" "를/JKO"     "사용하/VV"  "어/ECS"     "보/VXV"    
[11] "세요/EFN"   "./SF"    
```

## Bindings to kkma Java Objects


### MorphemeAnalyzer

```
text <- "안녕하세요. 형태소분석기를 사용해보세요."
ma <- new(MorphemeAnalyzer)
ret <- ma$analyze(text)              ## ArrayList of MExpression
ret <- ma$leaveJustBest(ret)         ## ArrayList of MExpression
sentlst <- ma$divideToSentences(ret) ## ArrayList of Sentence
sent <- sentlst$get(0L)              ## Sentence
eojeol <- sent$get(0L)               ## Eojeol
m <- eojeol$get(0L)                  ## Morpheme
m$getString()                        ## String. eg) "안녕"
m$getTag()                           ## String. eg) "NNG"
m$getSmplStr()                       ## String. eg) "안녕/NNG"
```

```
> unlist(sapply(sentlst, function(sent) sapply(sent, function(eojeol) sapply(eojeol, function(m) m$getSmplStr()))))
 [1] "안녕/NNG"   "하/XSV"     "세요/EFN"   "./SF"       "형태소/NNG"
 [6] "분석기/NNG" "를/JKO"     "사용하/VV"  "어/ECS"     "보/VXV"    
[11] "세요/EFN"   "./SF"   
```

