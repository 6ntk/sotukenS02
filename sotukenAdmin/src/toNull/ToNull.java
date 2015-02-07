package toNull;

import juken.JukenHoukokuInfo;

public class ToNull{

	private JukenHoukokuInfoToNull jhitn;

	public ToNull() {

		jhitn = new JukenHoukokuInfoToNull();
	}

	public JukenHoukokuInfoToNull getJhitn() {
		return jhitn;
	}

	public void toNull(JukenHoukokuInfo jhi){

		String tutiDate = jhi.getTutiDate();
		if(tutiDate == null){
			tutiDate = "";
		}
		if(tutiDate.equals("0000/00/00 00:00")  ||  tutiDate.equals("") || tutiDate.equals(null)){
			jhitn.setTutiDate("");
		}else{
			jhitn.setTutiDate(jhi.getTutiDate() + "　頃");
		}
		if(jhi.getIppanTime() == 0)
		{
			jhitn.setIppanTime("");
		}else{
			 jhitn.setIppanTime(String.valueOf(jhi.getIppanTime()) + "　分");
		}

		if(jhi.getSenmonTime() == 0)
		{
			jhitn.setSenmonTime("");
		}else{
			jhitn.setSenmonTime(String.valueOf(jhi.getSenmonTime()) + "　分");
		}
		if(jhi.getSonoTime() == 0)
		{
			jhitn.setSonoTime("");
		}else{
			jhitn.setSonoTime(String.valueOf(jhi.getSonoTime()) + "　分");
		}

			/* 文 */
		if(jhi.getBunTime() == 0)
		{
				jhitn.setBunTime("");
		}else{
			jhitn.setBunTime(String.valueOf(jhi.getBunTime()) + "　分");
		}
		if(jhi.getBunRyo() == 0)
		{
			jhitn.setBunRyo("");
		}else{
			jhitn.setBunRyo(String.valueOf(jhi.getBunRyo()) + "　字");
		}
		if(jhi.getKanseido() == 0)
		{
			jhitn.setKanseido("");
		}else{
			jhitn.setKanseido(String.valueOf(jhi.getKanseido()) + "　％");
		}

		/* 検査 */
		if(jhi.getKensaTime() == 0)
		{
			jhitn.setKensaTime("");
		}else{
			jhitn.setKensaTime(String.valueOf(jhi.getKensaTime()) + "　分");
		}

			/* 面接 */
		if(jhi.getMenNin1() == 0)
		{
			jhitn.setMenNin1("");
		}else{
			jhitn.setMenNin1(String.valueOf(jhi.getMenNin1()) + "　人");
		}
		if(jhi.getMenNin2() == 0)
		{
			jhitn.setMenNin2("");
		}else{
			jhitn.setMenNin2(String.valueOf(jhi.getMenNin2()) + "　人（本人を含め）");
		}
		if(jhi.getMenTime() == 0)
		{
			jhitn.setMenTime("");
		}else{
			jhitn.setMenTime(String.valueOf(jhi.getMenTime()) + "　分");
		}
	}

}
