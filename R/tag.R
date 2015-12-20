##' tag
##'
##' @param text a string
##' @export
tag <- function(text) {
    rma <- new(RMorphemeAnalyzer)
    ans <- rma$analyze(text)$toMorphStringArray()
    ans
}

