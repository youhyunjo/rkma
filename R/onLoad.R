.assign.classnames <- function() {
    .jaddLibrary('kkma', 'inst/java/org.snu.ids.ha.jar')
    .jaddClassPath('inst/java/rkma.jar')
    MorphemeAnalyzer <<- J("org/snu/ids/ha/ma/MorphemeAnalyzer")
    KeywordExtractor <<- J("org/snu/ids/ha/index/KeywordExtractor")
    POSTag <<- J("org/snu/ids/ha/constants/POSTag")
    Parser <<- J("org/snu/ids/ha/sp/Parser")
    Hangul <<- J("org/snu/ids/ha/util/Hangul")
    Dictionary <<- J("org/snu/ids/ha/dic/Dictionary")
    RMorphemeAnalyzer <<- J("io/github/youhyunjo/rkma/RMorphemeAnalyzer")
}

##' S4 binding to MorphemeAnalyzer
##'@export
MorphemeAnalyzer <- NULL

##' S4 binding to KeywordExtractor
##'@export
KeywordExtractor <- NULL

##' S4 binding to POSTag
##'@export
POSTag <- NULL

##' S4 binding to Parser
##'@export
Parser <- NULL

##' S4 binding to Hangul
##'@export
Hangul <- NULL

##' S4 binding to Dictionary
##'@export
Dictionary <- NULL

##' S4 binding to RMorphemeAnalyzer
##'@export
RMorphemeAnalyzer <- NULL

.onLoad <- function(libname, pkgname) {
    .jpackage(pkgname, lib.loc = libname)
    .jinit(parameters=c("-mx512m"))
    .assign.classnames()
}

