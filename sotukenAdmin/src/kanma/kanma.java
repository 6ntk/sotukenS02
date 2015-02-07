package kanma;

import java.util.StringTokenizer;

public class kanma {

	public kanma() {}

	public String[] kanmaKugiri(String kugiri) {

        //StringTokenizerオブジェクトの生成
        StringTokenizer st = new StringTokenizer(kugiri , ",");  //デリミタも同時に指定する
        String kanmaA[];
        kanmaA = new String [50];
        int i = 0;

        //分割した文字を画面出力する
        while (st.hasMoreTokens()) {

        	kanmaA[i] = st.nextToken();
        	i++;
        }

        return kanmaA;
	}
}
