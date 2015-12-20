package io.github.youhyunjo.rkma;
import java.util.List;

import org.snu.ids.ha.ma.MExpression;
import org.snu.ids.ha.ma.MorphemeAnalyzer;
import org.snu.ids.ha.ma.Sentence;

public class RMorphemeAnalyzer {
	private MorphemeAnalyzer ma;
	
	public RMorphemeAnalyzer() {
		this.ma = new MorphemeAnalyzer();
	}

	public RSentenceList analyze(String text) throws Exception {
		if( text.trim().equals("") ) return null;
		List<MExpression> ret = this.ma.analyze(text);
		ret = this.ma.postProcess(ret);
		ret = this.ma.leaveJustBest(ret);
		List<Sentence> stl = this.ma.divideToSentences(ret);
		return new RSentenceList(stl);
	}

}
