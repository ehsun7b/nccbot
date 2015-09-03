package com.ehsunbehravesh.nccbot.joke;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Ehsun Behravesh <post@ehsunbehravesh.com>
 */
public class JokeBank {

  private final static ConcurrentHashMap<Integer, Integer> lastQuery = new ConcurrentHashMap<>();

  private static final String[] jokes = {
    "آیا می‌دانید "
    + "‏( Sweet Dream ‏) ﭼﯿﺴﺖ ؟\n"
    + ".\n"
    + ".\n"
    + ".\n"
    + ".\n"
    + "ﭘﺎﺳُﺦ ﻣُﺜﺒﺖِ ﯾﮏ ﻣﺸﻬﺪﯼ ﺑﻪ ﺯﺍﺋﺮﯼ ﮐﻪ ﺩﻧﺒﺎﻝِ ﺳﻮﺋﯿﺖ ﻣﯿﮕﺮﺩﻩ !!",
    "به یک نفر گفتن که با کاروان یه جمله بساز گفت :توی حمام هیچوقت دوش کار وان رو نمیکنه",
    "آیا میدانید "
    + "“نوکوشیمورو” چیست !؟\n"
    + "نام دختری ژاپنی ؟ نام همسر پادشاه چین ؟\n"
    + "نام عمه سوسانو !؟\n"
    + "نه دوستان !\n"
    + "ندای مضطرب یک جوان مشهدی سوار بر پشت موتورسیکلت دوستش میباشد\n"
    + "و منظورش اینست که من را به کشتن ندهى",
    "جر و بحث دو تا مشهدى سر جاى پارک ماشین :\n"
    + "\n"
    + ".\n"
    + "\n"
    + ".\n"
    + "\n"
    + ".\n"
    + "\n"
    + ".\n"
    + "\n"
    + ".\n"
    + "\n"
    + ".\n"
    + "\n"
    + ".\n"
    + "\n"
    + "اگه بذرى بذرم مذرم بذرى ولى اگه نذرى بذرم ابولفضلی نه خودم مذرم نه مذرم تو بذرى . . .",
    "دوست عزیز اگر روزی دیدی دشمن داری\n"
    + "بدان یک جا یک کرمی ریخته ای\n"
    + "الزاما دلیل بر موفقیت شما نیست !",
    "میگن رفیقای فیثاغورث هر وقت میدیدنش می پرسیدن :\n"
    + "راستی اون قضیه چی شد ؟",
    
  };

  public String joke(Integer chatId) {
    //return "Chat ID: " + chatId;
    Integer lastJokeIndex = lastQuery.get(chatId);
    System.out.println("last joke index: " + lastJokeIndex);

    Random rand = new Random(System.currentTimeMillis());
    Integer index = rand.nextInt(jokes.length);

    while (Objects.equals(index, lastJokeIndex)) {
      index = rand.nextInt(jokes.length);
    }

    System.out.println("index: " + index);

    if (index != null) {
      lastQuery.put(chatId, index);
    }

    return jokes[index];
    //return "joke";
  }
}
