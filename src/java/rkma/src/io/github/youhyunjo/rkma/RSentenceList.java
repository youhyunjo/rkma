package io.github.youhyunjo.rkma;

import java.util.ArrayList;
import java.util.List;

import org.snu.ids.ha.ma.Eojeol;
import org.snu.ids.ha.ma.Morpheme;
import org.snu.ids.ha.ma.Sentence;

public class RSentenceList {
	private List<Sentence> sentList;
	public RSentenceList(List<Sentence> stl) {
		this.sentList = stl;
	}
	
	public String[] toMorphStringArray() {		
		ArrayList<String> morphList = new ArrayList<String>(); 
		for(int i=0; i < this.sentList.size(); i++) {
			Sentence st = (Sentence) this.sentList.get(i);
			for(int j=0; j < st.size(); j++) {
				Eojeol eojeol = st.get(j);
				for(int k=0; k < eojeol.size(); k++) {
					Morpheme m = eojeol.get(k);
					morphList.add(m.getSmplStr());
				}
			}
		}
		return morphList.toArray(new String[morphList.size()]);
	}
	
	
	public Sentence[] toSentenceArray() {
		
		ArrayList<Sentence> sentList = new ArrayList<Sentence>(); 
		for(int i=0; i < this.sentList.size(); i++) {
			sentList.add((Sentence) this.sentList.get(i));
		}
		return sentList.toArray(new Sentence[sentList.size()]);
	}	
	
	
	
	
}
