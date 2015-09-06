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
    "ﻣﺮﺩﺍﻧﯽ ﺭﺍ ﻣﯿﺸﻨﺎﺳﻢ ﮐﻪ ﻫﻨﮕﺎﻡ ﺩﻋﻮﺍ ﺑﺎ ﻫﻤﺴﺮﺷﺎﻥ\n"
    + "ﺑﺎﻋﺼﺒﺎﻧﯿﺖ ﺩﺍﺩ ﻧﻤﯿﺰﻧﻨﺪ\n"
    + "ﻧﻤﯿﺸﮑﻨﻨﺪ\n"
    + "ﺗﻬﻤﺖ ﻧﻤﯿﺰﻧﻨﺪ\n"
    + "\" ﺗﻨﻬﺎ \"\n"
    + "ﻗﺪﻡ ﻣﯿﺰﻧﻨﺪ ﻭ ﺩﺭ ﺧﻠﻮﺕ ﺧﻮﺩ ﻓﺮﻭ ﻣﯿﺮﻭﻧﺪ ﻭ ....\n"
    + ".\n"
    + ".\n"
    + ".\n"
    + ".\n"
    + "ﺑﻪ ﺩﻭﺳﺖ ﺩﺧﺘﺮﺷﻮﻥ ﺯﻧﮓ ﻣﯿﺰﻧﻨﺪ ﻭ ﻣﯽ ﮔﻮﯾﻨﺪ\n"
    + "ﺟﻮﺟﻮﯼ ﻣﻦ ﭼﻄﻮﺭﻩ؟\n"
    + "ﻋﻨﺘﺮﺧﺎﻧﻮﻡ ﺑﺎﺯ فاتحه خوندﻩ ﺑﻪ ﺍﻋﺼﺎﺑﻢ..",
    "ﻓﺴﻨﺠﻮﻥ ﭼﯿﺴﺖ؟\n"
    + ".\n"
    + ".\n"
    + "\n"
    + ".\n"
    + ".\n"
    + "ﻏﺬﺍﯾﯽ ﮐﻪ ﻭﺭﻭﺩﯼ ﻭ ﺧﺮﻭﺟﯽ ﺍﻭﻥ ﯾﻪ ﺷﮑﻠﻪ ...\n"
    + "ﺧﺪﺍ ﺷﺎﻫﺪﻩ ﻓﺤﺶ ﺑﺪﯼ\n"
    + "ﻧﺎﺭﺍﺣﺖ ﻣﻴﺸﻤﺎﺍﺍﺍﺍﺍﺍﺍ",
    "نظر دخترا راجع به مردها...\n"
    + "همه مردا عوضی هستن ! فقط بابام خوبه....\n"
    + ".\n"
    + ".\n"
    + ".\n"
    + ".\n"
    + ".\n"
    + ".\n"
    + "\n"
    + ".\n"
    + ".\n"
    + ".\n"
    + "حالا نظر مادرشون : \n"
    + "بابات از همه عوضی تره!!!",
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
    "Girl: You would be a good dancer except for two things. \n"
    + "Boy: What are the two things? \n"
    + "Girl: Your feet.",
    "My friend said he knew a man with a wooden leg named Smith. \n"
    + "So I asked him \"What was the name of his other leg?\"",
    "Patient: Doctor, I have a pain in my eye whenever I drink tea. \n"
    + "Doctor: Take the spoon out of the mug before you drink.",
    "Mother: \"Did you enjoy your first day at school?\" \n"
    + "Girl: \"First day? Do you mean I have to go back tomorrow?",
    "Little Johnny: Teacher, can I go to the bathroom? \n"
    + "Teacher: Little Johnny, MAY I go to the bathroom? \n"
    + "Little Johnny: But I asked first!",
    "Son: Dad, what is an idiot? \n"
    + "Dad: An idiot is a person who tries to explain his ideas in such a strange and long way that another person who is listening to him can't understand him. Do you understand me? \n"
    + "Son: No."
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

    lastQuery.put(chatId, index);

    return jokes[index];
    //return "joke";
  }
}
