package com.example.myapplication.lession

import android.os.Bundle
import android.view.*
import androidx.fragment.app.*
import androidx.recyclerview.widget.*
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentLessonBinding
import com.example.myapplication.lession_detail.LessonDetail
import com.example.myapplication.model.*
import java.util.*

class LessonFragment : Fragment(), StaggeredRVAdapter.ClickListener {
    
    lateinit var binding: FragmentLessonBinding
    companion object {
        const val NUM_COLUMNS = 2
    }
    
    private val lessons = ArrayList<Lesson>()
 
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for requireContext() fragment
        binding = FragmentLessonBinding.inflate(layoutInflater)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLessons()
    }
    
    private fun initLessons() {
        val lesson1 = Lesson("Bài 1: Họa tiết hình kỷ hà", R.drawable.p1)
        val groupMacLuoi = Group("Nhóm mắc lưới")
        val groupVongTron = Group("Nhóm vòng tròn")
        val groupHoiVan = Group("Nhóm hồi văn")
        groupMacLuoi.items.add(resources.getString(R.string.bai_1_string_1))
        groupMacLuoi.addImageRange(1, 3, requireContext())
        groupMacLuoi.items.add(resources.getString(R.string.bai_1_string_2))
        groupMacLuoi.addImageRange(4, 8, requireContext())
        groupMacLuoi.items.add(resources.getString(R.string.bai_1_string_3))
        groupMacLuoi.addImageRange(9, 10, requireContext())
        groupMacLuoi.items.add(resources.getString(R.string.bai_1_string_4))
        groupMacLuoi.addImageRange(11, 12, requireContext())
        groupVongTron.items.add(resources.getString(R.string.bai_1_string_5))
        groupVongTron.addImageRange(13, 13, requireContext())
        groupVongTron.items.add(resources.getString(R.string.bai_1_string_6))
        groupVongTron.addImageRange(14, 15, requireContext())
        groupVongTron.items.add(resources.getString(R.string.bai_1_string_7))
        groupVongTron.addImageRange(16, 16, requireContext())
        groupVongTron.items.add(resources.getString(R.string.bai_1_string_8))
        groupHoiVan.addImageRange(17, 17, requireContext())
        groupHoiVan.items.add(resources.getString(R.string.bai_1_string_9))
        groupHoiVan.addImageRange(18, 20, requireContext())
        groupHoiVan.items.add(resources.getString(R.string.bai_1_string_10))
        groupHoiVan.addImageRange(21, 29, requireContext())
        groupHoiVan.items.add(resources.getString(R.string.bai_1_string_11))
        groupHoiVan.addImageRange(30, 32, requireContext())
        groupHoiVan.items.add(resources.getString(R.string.bai_1_string_12))
        groupHoiVan.addImageRange(33, 35, requireContext())
        val listLesson1: MutableList<Group?> = ArrayList<Group?>()
        listLesson1.add(groupMacLuoi)
        listLesson1.add(groupVongTron)
        listLesson1.add(groupHoiVan)
        lesson1.groups = listLesson1
        lessons.add(lesson1)
        val lesson2 = Lesson("Bài 2: Họa tiết chữ", R.drawable.p41)
        val group2 = Group("")
        group2.items.add(
            "Trong Hán tự có nhiều chữ tượng ý dù rằng thuở ban đầu chữ Hán là hình vẽ dùng để chỉ " +
                    "sự vật. Lối chữ Hán cổ đã được tiến hóa rất đáng kể nên có giá trị trang trí rất lớn. Chẳng " +
                    "hạn hình vẽ ba đỉnh nhọn nằm ngang trên cùng một đường chân trời để chỉ trái núi, rồi " +
                    "sau này biến thể thành chữ ‘sơn’ (山); tuy rằng hiện nay đôi khi vẫn còn thấy lối viết cổ " +
                    "trên một vài tấm biển nhỏ."
        )
        group2.items.add(
            ("Chữ hiện nay khác rất xa với chữ cổ, tác dụng trang trí thêm nhiều hơn. Hoặc mềm mại " +
                    "và liền nét, hoặc rộng và phẳng lì, hoặc cong cong và cứng còng; dù cho đan chen hay " +
                    "chồng lớp lên nhau theo hình kỷ hà, nằm gọn trong một ô vuông hay tự do phóng túngnét; chữ hiện đại vẫn là th")
        )
        group2.items.add(
            ("Tên các tấm giấy to lại thấy có tác dụng khác: nghệ thuật mang nét phóng khoáng. Người " +
                    "nghệ sĩ phóng bút thảo nhanh các nét chữ chẳng chút ngượng tay, cho ra một tác phẩm " +
                    "trang nhã hài hòa với ý tưởng tinh tế của câu chữ. Những nét móc, nét xổ, nét ngang, … " +
                    "được tuôn ra từ ngọn bút lông thấm mực. Tôi có biết một nghệ sĩ Huế đã quá cố từng vẽ " +
                    "chữ chỉ bằng đầu ngọn tre đập cho tưa dập, nó khiến cho tác phẩm của ông có nét vừa " +
                    "mộc mạc quê mùa vừa có tính tìm tòi sáng tạo. Ông có biệt danh là Khóa Cọ như người " +
                    "ta thường gọi. Bởi vì ông không vẽ như mọi họa sĩ thông thường mà là “chùi cọ”, nhưng " +
                    "nói theo nghệ thuật phương Tây là vẽ phác. Với mực Tàu, ông chẳng những viết chữ mà " +
                    "còn vẽ thêm các tích cổ với hình hoa, lá, chim, đá , … vào các câu đối (hình LIII), đúng " +
                    "là một bậc thạc nho. Quả là nghệ thuật, nhưng phải thú nhận đó là thứ nghệ thuật hiện " +
                    "đang suy tàn.")
        )
        group2.items.add(
            "Trong các trường hợp này mục đích trang trí là thứ yếu. Điều mà người ta muốn nói lên " +
                    "trước tiên là tư duy: người nghệ sĩ làm sao cho chữ viết thanh cao nhất."
        )
        group2.items.add(
            ("Nhưng đối với một số chữ, mục đích trang trí có tính nhạy cảm hơn như chữ ‘phúc’, chữ " +
                    "‘lộc’, chữ ‘thọ’, chữ ‘hỉ’, v.v. … (hình XXXVI). Trên hết tất cả, các chữ này đều hàm ý " +
                    "mang đến điều may mắn như ý, như một thứ bùa cầu may lồng trong chúng. Người ta tin " +
                    "điều đó có hiệu quả nên ban phát chúng khắp nơi; công việc thường làm đó đã dẫn người " +
                    "nghệ sĩ dùng chúng làm họa tiết trang trí. Chúng được cách điệu bằng mọi kiểu (hình " +
                    "XXXVII, XXXVIII, XXXIX); chúng bị giản lược lại rất nhiều, chỉ còn nét vòng vòng " +
                    "hay khúc khuỷu, giản lược thành hình chữ nhật của chữ triện (hình XXIX, XLII, XLV, " +
                    "LXXXIII, CIV v.v. …), cho chúng mang hình cái lư hương (hình XLIII, XLVII, ,,,); cho " +
                    "chúng kết hợp với hồi văn (hình XLIII, XLIV, XLV); với dây lá (hình XLVI, XLVII, " +
                    "XLVIII, XLIX). Chúng được trang trí cho các bình phong, màn trướng, tường bao, cửa sổ " +
                    "tròn hay vuông (hình XL, XLI, XLII).")
        )
        group2.items.add(
            ("Thường chữ ‘thọ’ được dùng nhiều và rất đa dạng. Nhiều người An Nam, trong đó có cả " +
                    "nho sĩ, hay dùng chữ ‘thọ’ cách điệu để trang trí. Chưa bao giờ tôi đủ khả năng phân biệt " +
                    "sự khác biệt giữa chữ ‘thọ’ với chữ ‘phúc’ hay chữ ‘lộc’ đã được cách điệu hóa để dùng " +
                    "trong mục đích trang trí. Tôi đành chấp nhận lối giải thích của người An Nam và sưu tập " +
                    "tất cả các dạng chữ ‘thọ’ đó.")
        )
        group2.items.add(Picture(R.drawable.p36, "Hình 36"))
        group2.items.add(Picture(R.drawable.p37, "Hình 37"))
        group2.items.add(Picture(R.drawable.p38, "Hình 38"))
        group2.items.add(Picture(R.drawable.p39, "Hình 39"))
        group2.items.add(Picture(R.drawable.p40, "Hình 40"))
        group2.items.add(Picture(R.drawable.p41, "Hình 41"))
        group2.items.add(Picture(R.drawable.p42, "Hình 42"))
        group2.items.add(Picture(R.drawable.p43, "Hình 43"))
        group2.items.add(Picture(R.drawable.p44, "Hình 44"))
        group2.items.add(Picture(R.drawable.p45, "Hình 45"))
        group2.items.add(Picture(R.drawable.p46, "Hình 46"))
        group2.items.add(Picture(R.drawable.p47, "Hình 47"))
        group2.items.add(Picture(R.drawable.p48, "Hình 48"))
        group2.items.add(Picture(R.drawable.p49, "Hình 49"))
        group2.items.add(Picture(R.drawable.p50, "Hình 50"))
        group2.items.add(Picture(R.drawable.p51, "Hình 51"))
        group2.items.add(
            ("Có một chữ rất đặc thù là chữ ‘hỉ’. Một đôi khi nó được dùng một mình nhưng thường " +
                    "được ghép đôi hai chữ với nhau, gọi là ‘song hỉ’ (hình LII). Đó là biểu tượng trang trí " +
                    "mang ý nghĩa chung vui, hạnh phúc lứa đôi, tức niềm mong ước của những vợ chồng mới " +
                    "cưới.")
        )
        group2.items.add(Picture(R.drawable.p52, "Hình 52"))
        group2.items.add(Picture(R.drawable.p53, "Hình 53"))
        val listLesson2: MutableList<Group?> = ArrayList<Group?>()
        listLesson2.add(group2)
        lesson2.groups = listLesson2
        lessons.add(lesson2)
        val lesson3 = Lesson("Bài 3: Họa tiết hình tĩnh vật", R.drawable.hinhtinhvat)
        val group3 = Group("")
        group3.items.add(
            "Nhiều món tĩnh vật đã đi vào họa tiết trang trí của người An Nam. Hồi văn hình kệ trên " +
                    "doanh liên (cặp biển câu đối) chúng ta đã thấy ở hình XXXV là một ví dụ."
        )
        group3.items.add(
            ("Trên cao đề kỷ (món đồ gỗ có dạng hồi văn) người nghệ sĩ đặt trên đó những món đồ thờ, " +
                    "như bộ tam sự gồm lư hương, bát nhang và ống nhang đèn; hoặc bộ ngũ sự như chúng ta " +
                    "đã biết hồm ba món trên và hai cái chân đèn.1 Tuy nhiên người nghệ sĩ có thế thế một vài " +
                    "món trong đó bằng bình hoa trang nhã (hình LIV, LV, LVI) hay quả bồng (plateau à " +
                    "offrandes) đựng thức cúng, một cái khánh tượng trưng cho đại phúc, một pho sách, một " +
                    "quản bút lông … (hình LVII). Tất cả các món này thể hiện độc lập với cao đề kỷ đỡ " +
                    "chúng bên")
        )
        group3.items.add(Picture(R.drawable.p54, "Hình 54"))
        group3.items.add(Picture(R.drawable.p55, "Hình 55"))
        group3.items.add(Picture(R.drawable.p56, "Hình 56"))
        group3.items.add(Picture(R.drawable.p57, "Hình 57"))
        group3.items.add(
            ("Cuốn thư có công dụng lớn. Về nguyên tắc đó là một cuộn giấy giỡ ra nửa chừng, hai đầu " +
                    "hơi cuộn vào. Người dùng cuốn thư thay cho hoành phi (en-tête des panneaux à sentence " +
                    "– hình LVIII) hay trang trán tường phía trên cửa (fronton de porte). Nhưng thông thường " +
                    "nó dùng trang trí các biểu tượng (hình LIX). Phần lớn các bìnhphong đều có dạng cuốn " +
                    "thư gấp, có thể còn nguyên dạng hay đã biến cách ít nhiều. Các tấm bình phong, còn " +
                    "nguyên tấm hay có trổ lỗ, là nơi hội tụ mọi họa tiết trang trí (hình LXI, LXVII, CLVII).")
        )
        group3.items.add(Picture(R.drawable.p58, "Hình 58"))
        group3.items.add(Picture(R.drawable.p59, "Hình 59"))
        group3.items.add(Picture(R.drawable.p60, "Hình 60"))
        group3.items.add(
            ("Hỏa châu (tráu châu, quả châu) thường thấy ở chính giữa gờ nóc đền chùa. Mô-típ thông " +
                    "thường của hỏa châu gồm một ‘mặt nguyệt’ (một dĩa hình tròn tựa trên mấy cụm mây) " +
                    "xung quanh có các ngọn lửa. Nhưng cũng có biến cách: mặt nguyệt để trên đầu con rồng " +
                    "nhìn chính diện, v.v… Họa tiết này thường kèm theo hình hai con rồng ở hai đầu gờ nóc " +
                    "mái, gai on rồng có thể thể hiện nguyên hình hay có biến cách đi. Mô-típ này có tên là " +
                    "“lưỡng long triều nguyệt”. Chúng ta có thể thấy hỏa châu ở một trán bia (hình LXIV). Có " +
                    "khi hỏa châu kết hợp với biểu tượng âm dương (hình LXV) có khi với hoa mẫu đơn, hai " +
                    "con rồng có thể ở xa hai ñaàu hay áp sát lại gần hỏa châu (hình LXVI, LXVII).")
        )
        group3.items.add(Picture(R.drawable.p61, "Hình 61"))
        group3.items.add(Picture(R.drawable.p62, "Hình 62"))
        group3.items.add(Picture(R.drawable.p63, "Hình 63"))
        group3.items.add(Picture(R.drawable.p64, "Hình 64"))
        group3.items.add(Picture(R.drawable.p65, "Hình 65"))
        group3.items.add(
            ("Trên gờ nóc mái có khi thay thế hỏa châu bằng trái bầu, trường hợp này chí thấy chùa " +
                    "chiềng và phủ đệ. Đó là biểu tượng cổ của Phật giáo, mang ý nghĩa mọi thứ trù phú (2). " +
                    "Hồi nhớ lại có thể kể thêm những món thứ yếu khác: quả tua và tua viền (ví dụ hình " +
                    "XXX), ngọn lửa (hình LXIII, LXIV), dãi vải (hình LXIX) và dãi vải đôi khi có biến cách " +
                    "thành ngọn lửa, khói (hình LIV, LV), mây vây quanh rồng (hình CXXII), sóng biển cách " +
                    "điệu uốn cuộn gọi là thủy ba (hình CLXV); đá cách điệu (hình CCXIV), quả cầu ở hình " +
                    "tượng sư tử hí cầu (hình CXCV) .")
        )
        group3.items.add(Picture(R.drawable.p66, "Hình 66"))
        group3.items.add(Picture(R.drawable.p67, "Hình 67"))
        group3.items.add(Picture(R.drawable.p68, "Hình 68"))
        group3.items.add(
            ("Đôi chỗ họa tiết thể hiện nhiều hình tĩnh vật, thường thấy nhất là ‘bát bửu’, ở đòn tay, ở " +
                    "giữa tấm vách ngăn buồng, hiếm thấy hơn như trên đồ gỗ và hòm rương. Tĩnh vật trong " +
                    "bộ bát bửu rất lan man. Tùy từng tác giả có khi thêm vào món này có khi bỏ ra món khác. " +
                    "Một bộ bát bảo thấy ở nhiều tác giả như sau: quả bầu, quạt, gươm, đàn, quyển sách, bút, " +
                    "cây sáo, phất trần; và xin nói thêm thành ngữ bát bảo (tám món đồ báu vật) nghe có vẽ " +
                    "quá đáng so với mấy món đồ kia. Trong cuốn Cour Supérieur d’Annamite (Pháp Ty Viện " +
                    "An Nam), đệ nhất lục cá nguyệt 1909, ông H. Tissot kê bát bảo gồm: pho sách, như ý, " +
                    "lẵng hoa, bầu rượu, cây đàn, cái quạt, phất trần. Còn ông G. Dumoutier trong cuốn Les " +
                    "Symboles, les Emblèmes, les Accessoire de Culte Annamute (Biểu tượng, Biểu trưng và " +
                    "Tự khí An Nam) cho là: hai cây sáo ghép đôi, cây đàn tỳ bà, cái quạt, lẵng hoa, pho sách, " +
                    "cuốn thư, cái khánh, và quả bầu.")
        )
        group3.items.add(
            ("Còn đây là bát bảo theo Trung Hoa, thấy chẳng khác gì của An nam. Trong cuốn L’Art " +
                    "Chinois (Mỹ Thuật Trung Hoa), các trang 237-239, Bushell viết: " +
                    "“Biểu tượng của Đạo giáo,tám món bửu bối của các vì tiên: cây quạt của Chung Ly " +
                    "Quyền có phép quạt hồi sinh người chết, thanh gươm tần của Lã Động Tân ; quả bầu tiên " +
                    "của Lý Thiết Quài, cặp sênh phách của Tào Quốc Cựu, giõ hoa của Lam Thái Hòa, ống " +
                    "trúc và đôi gậy của Trương Quả Lão, cây sáo của Hàn Tương Tử, hoa sen của Hà Tiên " +
                    "Cô.")
        )
        group3.items.add("“Bách cổ (100 món cổ vật) bao gồm bát bảo và bốn ngón mỹ thuật ‘cầm, kỳ, thi, họa’.")
        group3.items.add(
            "“Bát bảo này có châu, kim tiền, cuốn thư (biểu tượng chiến thắng) , thư (sách), họa (bức " +
                    "tranh), khánh ngọc, cặp chén rượu sừng tê giác, lá bối.”"
        )
        group3.items.add(
            ("Còn phức tạp thêm khi thấy có bát bảo của Phật giáo: bánh xe pháp, tù và, bảo cái, bảo " +
                    "tán, hoa sen, bình bát, mỏ, dây liên hoàn. Có khi còn có thêm chữ vạn, lư hương bốn chân, " +
                    "một chữ cổ, cái chuông.")
        )
        group3.items.add(
            ("Quả là vô ích khi muốn xác định bát bảo, ai cũng thấy vậy. Nhưng nó là một quan niệm " +
                    "cho rằng những vật đó mang lại sự tốt lành cho con người. cho con người thụ hưởng mọi " +
                    "mặt về iinh thần lẫn tâm hồn. Như giõ hoa biểu tượng cho sự trẻ trung, thanh gươm nói " +
                    "lên sự vinh quang của người lính, khánh chỉ về hạnh phúc tột cùng.")
        )
        group3.items.add(Picture(R.drawable.p69, "Hình 69"))
        group3.items.add(Picture(R.drawable.p70, "Hình 70"))
        val listLesson3: MutableList<Group?> = ArrayList<Group?>()
        listLesson3.add(group3)
        lesson3.groups = listLesson3
        lessons.add(lesson3)
        val lesson4 = Lesson("Bài 4: Họa tiết hoa, lá - dây lá và quả", R.drawable.p79)
        val group4 = Group("")
        group4.items.add(
            "Trong nghệ thuật trang trí của người An Nam, giới thực vật cũng được sử dụng với họa " +
                    "tiết hoa, lá, dây là, và quả."
        )
        group4.items.add(Picture(R.drawable.p74, "Hình 74"))
        group4.items.add(
            ("Lá là họa tiết trang trí đơn giản (hình LXXV, LXXIX), còn dây lá rườm rà và có kích " +
                    "thước rộng hơn (hình LXXXVII). Khi họa tiết chạy viền khổ hẹp theo một khung thì gọi " +
                    "là ‘đằng’ (dây leo) như liên đằng (dây trang trí lá sen3), lan đằng (dây trang trí cây lan) " +
                    "(hình LXXIV)")
        )
        group4.items.add(Picture(R.drawable.p75, "Hình 75"))
        group4.items.add(Picture(R.drawable.p76, "Hình 76"))
        group4.items.add(Picture(R.drawable.p77, "Hình 77"))
        group4.items.add(Picture(R.drawable.p78, "Hình 78"))
        group4.items.add(Picture(R.drawable.p79, "Hình 79"))
        group4.items.add(
            ("Chỉ thỉnh thoảng mới thấy họa tiết lá mang hình dáng tự nhiên (hình XCIII), còn thường " +
                    "thì đều cách điệu hóa. Khi lá ló ra từ một trung tâm dày mẫm thì gọi là bẹ (hình LXXX, " +
                    "CX, …), loại này thường để trang trí gờ mái nhà hay đôi lúc dùng trang trí đỉnh cột (hình " +
                    "CXV). Ở bắc kỳ, đỉnh cột hay được trang trí hình bốn con chim phượng ‘cắt đuôi’, hình " +
                    "tượng này không thất vùng quanh Huế.")
        )
        group4.items.add(Picture(R.drawable.p80, "Hình 80"))
        group4.items.add(
            ("Tên các họa tiết hoa lá thật khó xác định, ngay các nghệ sĩ An Nam cũng nhiều khi không " +
                    "biết và họ hay biến đổi hình dáng theo ngẫu hứng. Tuy nhiên cũng có thể giới một một số " +
                    "như họa tiết “lá lật”4, được biến cách thành đầu rồng nhìn chính diện (hình LXXXI, " +
                    "LXXXII, LXXXIII, LXXXIV). Nhưng phần lớn các nghệ sĩ không biết gọi tên họa tiết " +
                    "này là gì, có người gọi là ‘lá’ có người gọi là ‘mặt nạ’ (hình CXXXVI).")
        )
        group4.items.add(Picture(R.drawable.p81, "Hình 81"))
        group4.items.add(Picture(R.drawable.p82, "Hình 82"))
        group4.items.add(Picture(R.drawable.p83, "Hình 83"))
        group4.items.add(Picture(R.drawable.p84, "Hình 84"))
        group4.items.add(Picture(R.drawable.p85, "Hình 85"))
        group4.items.add(
            ("Họa tiết thường dùng ở bờ mái nhà và mép đồ gỗ có tên ‘lá đề’, lá chẻ ba thùy và thùy " +
                    "giữa nhọn đầu. Nhưng một số nghệ sĩ Huế lại gọi là ‘vân kiên’雲肩 (vai áo hình như cụm " +
                    "mây). Quả quân lính An nam thời xưa trên vai áo và quanh cổ có miếng vải hình giống " +
                    "như thế. Một số khác lại đặt tên cho nó là ‘tam sơn’三山 (ba ngọn núi) vì ba thùy lá chẻ " +
                    "ra giống như vậy (hình LXXI, LXXII. Xem thêm y phục các vị thần ở hình CCVIII, " +
                    "CCXI). Ví dị này cho thấy các nghệ sĩ An Nam không thống nhất thuật ngữ họa tiết, khi " +
                    "thì gọi tên này khi thì gọi tên kia, chủ yếu dựa vào hình dáng họa tiết giống man máng " +
                    "vật họ từng thấy.")
        )
        group4.items.add(Picture(R.drawable.p86, "Hình 86"))
        group4.items.add(Picture(R.drawable.p87, "Hình 87"))
        group4.items.add(Picture(R.drawable.p88, "Hình 88"))
        group4.items.add(Picture(R.drawable.p89, "Hình 89"))
        group4.items.add(Picture(R.drawable.p90, "Hình 90"))
        group4.items.add(
            ("Hoa đã cách điệu cũng khó định danh, khó lòng đặt tên khi ở trên cụm lá quy ước. Một " +
                    "loại mô-típ hoa có thùy rộng nằm giữa họa tiết lá (hình LXXVI, LXXVII. LXXVIII), đôi " +
                    "khí ở ngay những nét đầu tiên của đầu rồng nhìn chính diện, có vẽ là hoa mẫu đơn. " +
                    "Nhưng giữa các nghệ sĩ có nhiều bất đồng tên gọi loại hoa này. Một số gọi đó là ‘bông " +
                    "tây’, một số khác gọi là nụ hoa cách điệu tranh trí ở cuối mô-típ hoa hay mô-típ chùm lá " +
                    "(hình LXXV). Tên này hay được các nghệ sĩ điêu khắc gọi đùa, có lẽ chịu ảnh hưởng của " +
                    "mô-típ trang trí du nhập từ Pháp qua hồi thế kỷ 18 hay đầu thế kỷ 19.")
        )
        group4.items.add(Picture(R.drawable.p91, "Hình 91"))
        group4.items.add(Picture(R.drawable.p92, "Hình 92"))
        group4.items.add(Picture(R.drawable.p93, "Hình 93"))
        group4.items.add(Picture(R.drawable.p94, "Hình 94"))
        group4.items.add(Picture(R.drawable.p95, "Hình 95"))
        group4.items.add(
            ("Họa tiết ‘hoa đào’ (hình XII) chỉ có 4 cánh hơi nhọn ở đầu. Họa tiết ‘hoa mai’5 có năm " +
                    "cánh (hình IX, X), đầu cánh bầu tròn. Họa tiết ‘bông bèo’ (giống hình cây bèo ở đần lầy) " +
                    "có bốn cánh, mép cánh có khía và co rúm giống hoa ở cây họ hoa hồng. Họa tiết ‘hoa " +
                    "chanh’ có tám cánh, trong đó có bốn cánh dài khá thon mảnh và bốn cánh trung gian " +
                    "ngắn hơn (hình II). Họa tiết ‘hoa thị’ do bốn hình tròn cắt nhau, có bốn thùy dài thỉnh " +
                    "thoảng chen vào các cánh trung gian ngắn hơn (hình XIV, XV, III). Họa tiết ‘hoa quỳ’ " +
                    "kết lại từ vành các cánh nhỏ hình tròn.")
        )
        group4.items.add(
            ("Chúng ta thấy hoa lá không thuần túy là họa tiết trang trí thôi, chúng còn là những biểu " +
                    "tượng hay điển cố. Một biểu tượng khá quen thuộc là ‘tứ thời’ (bốn mùa) gồm cây mai " +
                    "(mơ) tượng trưng cho mùa xuân, cây sen tượng trưng cho mùa hạ (hình XCV), cây cúc " +
                    "tượng trưng cho mùa thu, và cuối cùng cây tùng tượng trưng cho mùa đông (hình XCVII). " +
                    "Một số người gọi biểu tượng bốn mùa là ‘tứ quý’ gồm cây mai, cây sen, cây cúc và cây " +
                    "trúc (mai liên cúc trúc). Người ta dùng các mô-típ này (lá, hoa và dây lá trang trí trên " +
                    "những tấm ván của đồ gỗ, trên các chi tiết sườn nhà, … Hoa sen chủ yếu đi vào các trang " +
                    "trí Phật giáo. Hoa sen được cách điệu một cách đặc biệt (hình C, CI, CII) gợi lên hình ảnh " +
                    "tòa sen của Đức Phật.")
        )
        group4.items.add(
            ("Họa tiết cây cũng thường được biến cách theo truyền thống: nhánh mai hay nhánh đào " +
                    "mô-típ thành ‘phụng’, tùng và trúc thành ‘long’ (hình XCVII), sen thành ‘quy’, cúc thành‘lân’; loa kèn thành ‘long’. Thế nhưng ngẫu hứng của người nghệ sĩ còn cho phép họ biến " +
                    "cách mọi loài cây thành một con vật huyền thoại có quyền năng thần bí.")
        )
        group4.items.add(
            ("Có một loài hoa mà chúng ta chưa nhắc đến: ‘mẫu đơn’. Ở An Nam không có loài hoa " +
                    "này, tên nó dùng chỉ một loài hoa khác mọc hoang trên các ngọn đồi hay đánh trồng trong " +
                    "chậu kiểng; đó là cây ‘đơn’ (ixore?) có hoa hình tán từa tựa hoa mẫu đơn và người ta tin " +
                    "là vậy nên đưa vào điêu khắc và hội họa. Đó là sự nhầm lẫn. Hoa mẫu đơn thường biến " +
                    "cách thành con lân, đôi khi thành chim phụng (hình XCVIII), hay bất kỳ con vật siêu " +
                    "nhiên nào khác.")
        )
        group4.items.add(Picture(R.drawable.p96, "Hình 96"))
        group4.items.add(Picture(R.drawable.p97, "Hình 97"))
        group4.items.add(Picture(R.drawable.p98, "Hình 98"))
        group4.items.add(Picture(R.drawable.p99, "Hình 99"))
        group4.items.add(Picture(R.drawable.p100, "Hình 100"))
        group4.items.add(
            ("Nếu người nghệ sĩ giữ đúng truyền thống họa tiết, các loài hoa nói trên dễ thống nhất tên " +
                    "gọi. Nhưng khi do thiếu kiến thức, do sơ xuất hay là do ngẫu hứng, họ pha trộn các mô- " +
                    "típ với nhau thì khó xác định tên. Chẳng hạn có một trang trí dưới chân là một chùm lá " +
                    "cúc bị kéo dài ra, rồi cho thêm vào mấy lá ngắn và tròn hơn cỉa cây mẫu đơn, hai đầu lại " +
                    "có hoa mai (mơ). Tôi lưu ý trường hợp này lọt vào các nghệ sĩ làm hàng cho người Châu " +
                    "Âu nhưng lại có những ngẫu hứng đáng tiếc như vậy (hình XCV).")
        )
        group4.items.add(
            ("Các loại trái cây các tay điêu khác và hội họa An Nam hay dùng có: lê, đào, phật thủ, lựu, " +
                    "mảng cầu (quả na); hiếm hơn có nho, dưa (gọi là qua) và trái bầu (hình CV, CVI, CVII, " +
                    "CVIII). Quả lê biến cách thành ‘lân’, đào thành ‘quy’, phật thủ thành ‘đầu rồng nhìn " +
                    "chính diện’ (hình CIX), quả na thành ‘phụng’. Theo một số nghệ sĩ, bốn loại quả lê, lựu, " +
                    "đào, na thuộc bộ ‘tứ hữu’ (bốn người bạn).")
        )
        group4.items.add(
            ("Phần lớn các hia quả đều mang một ý nghĩa biểu tượng. Đào là loài cây được coi có tính " +
                    "thần bí, gỗ của nó trừ tà trục quỷ. Ở Trung Hoa các đạo sĩ thường khắc ấn bằng gỗ đào, " +
                    "gỗ đào còn được chuốc thành các mũi tên để bắn ma quỷ mưu toan hãm hại trẻ em. Mấy " +
                    "người bị bệnh mà người ta cho là do tà ma sẽ bị đánh bằng roi gỗ đào.")
        )
        group4.items.add(
            ("Ở An Nam hiếm có cây đào nên các tục mê tín này ít thịnh hành. Nhưng người ta đưa cây " +
                    "đào vào trang trí mỹ thuật là do du nhập tín ngưỡng từ Trung Hoa, cho rằng quả đào biểu " +
                    "tượng cho sự trường thọ. Tích Trung Hoa có kể: vua Hán Võ Đế được bà Tây Vương " +
                    "Mẫu ban cho bảy quả đào tiên, loại đào này ba ngàn năm mới nở hoa một lần và chờ ba " +
                    "ngàn năm nữa trái mới chín. Bà Vương mẫu mỗi năm háo đào tiên để mở hội Bàn Đào thết đãi chư tiên, vì thế nhiều vị tiên hoan hỉ đến dự hội để được ăn đào tiên. Người ta " +
                    "còn truyền tụng trong quả đào có chứa tiên dược. Nhân quả đào gọt thành hình cái khóa " +
                    "để làm bùa cho trẻ em đeo. Thêm nữa, Thọ Tinh (Ông Thọ), vị thần chủ về sự trường thọ, " +
                    "nhiều lúc được biểu tượng bằng quả đào. Chính những truyền thuyết và tín ngưỡng đó đã " +
                    "đưa quả đào vào nỹ thuật An Nam; loại quả này biểu tượng cho sự trường thọ, cho phúc " +
                    "đức. Trong văn học An Nam lại còn dựa vào quả đào có lớp lông mịn màng để mô tả cô " +
                    "gái đẹp (mơn mỡn đào tơ).")
        )
        group4.items.add(
            ("Quả lựu biểu tượng cho sự ‘con đàn cháu đống’ vì trong quả lựu có vô số hạt hồng hồng, " +
                    "mỗi hạt tượng trưng cho một đứa con đứa cháu. Do vì tiếng Hán hạt là chữ ‘tử’ cũng có " +
                    "nghĩa là con nên ở Trung Hoa người ta hay biếu quà cưới bằng quả lựu.để cô dâu chú rễ " +
                    "chúc đông con nhiều cháu.")
        )
        group4.items.add(
            "Sen cũng có biểu tượng giống như lựu vì trong búp sen có nhiều hạt. Thêm nữa, hoa sen " +
                    "lại là biểu tượng của Phật giáo."
        )
        group4.items.add(
            "Quả lê ở Trung Hoa cũng là biểu tượng cho đứa con do từ chữ ‘lê tử’ (quả lê) được trại ra " +
                    "thành ‘lập tử’ (có con). Vì có sự phát âm khác nên biểu tượng này ít dùng ở An Nam."
        )
        group4.items.add(
            "Ở Trung hoa quả dưa (qua 瓜) cũng được coi là biểu tượng đông con do quả dưa có nhiều " +
                    "hạt. Biểu tượng này có thấy ở những bức chạm, nhưng hiếm thôi."
        )
        group4.items.add(
            ("Quả bầu có hai ngăn dùng chứa nước cũng thấy trên các tấm biển, nó là một trong ‘bát " +
                    "bảo’ mà chúng ta đã có dịp nói đến. Quả bầu cũng thấy dùng trang trí ở giữa gờ nóc mái " +
                    "nhà nhưng hạn chế trong phạm vi phủ đệ và chùa chiềng7, biểu tượng cho sự trù phú, " +
                    "giàu có (hình VII, XLIX).")
        )
        group4.items.add(Picture(R.drawable.p101, "Hình 101"))
        group4.items.add(Picture(R.drawable.p102, "Hình 102"))
        group4.items.add(Picture(R.drawable.p103, "Hình 103"))
        group4.items.add(Picture(R.drawable.p104, "Hình 104"))
        group4.items.add(Picture(R.drawable.p105, "Hình 105"))
        group4.items.add(Picture(R.drawable.p106, "Hình 106"))
        group4.items.add(Picture(R.drawable.p107, "Hình 107"))
        group4.items.add(Picture(R.drawable.p108, "Hình 108"))
        group4.items.add(Picture(R.drawable.p109, "Hình 109"))
        group4.items.add(
            ("Trung Hoa coi mẫu đơn là nữ hoàng các loài hoa. Mẫu đơn đỏ tượng trưng cho sự hưởng " +
                    "thụ và giàu sang vì ở Trung Hoa và An Nam màu đỏ là màu cát tường. Hoa này cũng " +
                    "biểu tượng cho người ái thiếp. Lã Đồng tân, vị tiên bảo trợ cho văn nhân, thường thưởng " +
                    "ngoạn hoa mẫu đơn vì bà vợ xinh đẹp như tiên của ông từ đó hiện ra.")
        )
        group4.items.add(
            ("Bức tranh có hình cây tùng và con nai (tùng lộc) thường thấy trong các họa tiết trang trí " +
                    "cũng mang một ý nghĩa biểu tượng: cây tùng tượng trưng cho sự sống lâu (nên nhiều khi " +
                    "thấy đi chung với con hạc, cũng biểu tượng cho trường thọ), con nai chỉ ‘lộc’ được hưởng " +
                    "(tức làm quan, phú quý và may mắn). Chúng ta thấy tùng lộc là lời cầu chúc cho sống lâu " +
                    "và giàu sang. Họa tiết tùng hạc cũng có ý nghĩa như thế.")
        )
        group4.items.add(
            "Phần sau chúng ta sẽ thấy theo truyền thống cổ xưa chúng ta sẽ thấy nhiều con thú được " +
                    "kết hợp với nhiều loài thảo môc khác nhau."
        )
        group4.items.add(
            ("Đa số các trang trí dấu nhấn, nghĩa là các trang trí là bật lên độ cong của một đường nét " +
                    "hay thấy dùng trong kiến trúc, đều mượn từ họa tiết thực vật, Ở đây chúng ta đi từ đơn " +
                    "gián đến phúc tạp các họa tiết loại này: mỏ neo (hình CX:1), mỏ chim cu (hình CX:2), lá " +
                    "bẹ (hình CX:3), guột bẹ hay cuộn bẹ (hình CX:4), guột vân hay cuộn mây (hình CX:5-6), " +
                    "lá, hồi văn., tứ linh, cá.")
        )
        group4.items.add(Picture(R.drawable.p110, "Hình 110"))
        group4.items.add(Picture(R.drawable.p111, "Hình 111"))
        group4.items.add(Picture(R.drawable.p112, "Hình 112"))
        group4.items.add(Picture(R.drawable.p113, "Hình 113"))
        group4.items.add(Picture(R.drawable.p114, "Hình 114"))
        group4.items.add(Picture(R.drawable.p115, "Hình 115"))
        group4.items.add(Picture(R.drawable.p116, "Hình 116"))
        group4.items.add(Picture(R.drawable.p117, "Hình 117"))
        group4.items.add(
            ("Trong số các trang trí này có một số thoát sinh từ mô-típ trang trí khác. Chẳng hạn mỏ cu " +
                    "là họa tiết mỏ neo được làm dịu mắt bởi nền guột. Guột mây cũng có thể coi như mỏ cu, chỉ khác phần cuốu thay vì nhọn lại tròn và lớn hơn mỏ cu. Guột bẹ cũng là lá bẹ nhưng " +
                    "phần đuôi lá tròn đi và cuộn lại. Cụm lá cũng là những chiếc lá được kéo dài mãi ra và " +
                    "gấp khúc lại. Nói cho đúng, guột mây, lá bẹ, guột bẹ và cụm lá chỉ là sự phát triển lên hai " +
                    "yếu tố thuần túy ban đầu: mỏ neo và mỏ cu.")
        )
        group4.items.add(
            ("Hẳn nhiên hồi văn và họa tiết hình thú thuộc nhóm khác nhưng nói thêm ở đây vì có quá " +
                    "trình biến cách thành chúng. Kinh điển là sự biến cách của lá (lá hóa). Cụm lá đôi khi " +
                    "được dùng đơn thuần, nhưng thường thì phần dáy cụm lá hay hóa thành đầu giao long " +
                    "(hình CXVI). Hoặc guột chính của dây lá cổ con rồng đang ngẩng cao hay cổ con phụng " +
                    "được ghép thêm vào. Trường hợp này cũng thấy ở hồi văn. Guột mây thỉnh thoảng có " +
                    "một con mắt mà người ta nói giống đầu con thủy long (rồng nước). Cũng không nên " +
                    "không nhắc đến họa tiết mỏ cu khiêm tốn trang trí trên nóc máu giống hình con cá giản " +
                    "lược hóa đang quẩy đuôi.")
        )
        group4.items.add("Chủ đề dùng họa tiết dấu nhấn khá rộng, tựu trung có mấy quy tắc chính để theo.")
        group4.items.add(
            ("Đôi khi ở đầu chái nhà có trang trí mỏ neo. Hoặc là tương ứng với mỏ neo này trên gờ " +
                    "nóc mái có mỏ cu. Khi gờ nóc máu có hình lá bẹ, hay thường nhất là cụm lá, thì gờ nóc " +
                    "chái trang trí mỏ cu. Các ví dụ này đủ mang lại sự hình dung lối trang trí đơn giản. Khi " +
                    "xuất hiện họa tiết con vật linh - và đó là trường hợp ở cung điện hay chùa chiềng – con " +
                    "rồng luôn ngự trên nóc mái trừ phi ngôi chùa thờ Phật bà và trường hợp này thay bằng " +
                    "con phụng. Khi trang trí đến tứ linh, con lân luôn đứng sau con phụng và con rồng, dưới " +
                    "nữa là con rùa. Và tứ linh luôn kèm theo hoặc là họa tiết lá bẹ hoặc là họa tiết hồi văn, " +
                    "hoặc ít ra phải có mỏ cu hay mỏ neo; đôi khi có tất cả các họa tiết này cùng một lượt " +
                    "nhưng luôn luôn có sự giảm tiết dần. Đó là trang trí lớn.")
        )
        group4.items.add(
            ("Trong tranh trí cấp trung bình chúng ta thấy trên nóc mái có có long hay phụng; ở gờ các " +
                    "đầu hồi có lá hóa long, ở gờ đòn tay có hồi văn đơn giản hay biến cách. Hai mô-típ sau " +
                    "này có kèm theo lá bẹ, mỏ cu hay mỏ neo. Nhưng như tôi đã nói, các mô-típ này dược áp " +
                    "dụng một diện khá rộng (hình CXXXIX, CXL, CLVIII, …). " +
                    "(xem tiếp Bài 5: Họa tiết hình thú – Con rồng)")
        )
        group4.items.add(Picture(R.drawable.p118, "Hình 118"))
        val listLesson4: MutableList<Group?> = ArrayList<Group?>()
        listLesson4.add(group4)
        lesson4.groups = listLesson4
        lessons.add(lesson4)
        val lesson5 = Lesson("Bài 5: Họa tiết hình thú – con rồng", R.drawable.conrong)
        val group5 = Group("")
        group5.items.add(
            ("Trong số các con vật trang trí của người An Nam, bốn con vật siêu nhiên gọi là tứ linh " +
                    "chiếm vị trí đầu tiên.. Đó là long (rồng), ly (lân), qui (rùa) và phụng (phượng). Chúng là " +
                    "một biểu trưng của tín ngưỡng với những phẩm chất huyền bí. Bên cạnh còn thấy những " +
                    "con vật khác như hạc, sư tử, dơi, cá cũng mang ít nhiều đặc điểm tín ngưỡng. Con hổ " +
                    "cũng có tính chất rất đặc thù, nó đôi khi được thắp hương thờ cúng và dùng làm bùa chú " +
                    "để hóa giải và xua đuổi tà ma. Vã lại, chúng ta đã thấy trái cây cũng có tính chất ít nhiều " +
                    "như vậy, dùng làm lời cầu chúc mang mán tín ngưỡng và siêu nhiên.")
        )
        group5.items.add(
            ("Con rồng tiếng Hán Việt là long (龍) rất được ưa dùng trang trí mỹ thuật An Nam. Trong " +
                    "cung đình nó có vị trí riêng vì là biểu tượng của hoàng đế, nhưng cũng thấy rồng ở chùa " +
                    "chiềng và tư gia; đặt trên mái nhà, đầu hồi, đòn tay, trên đồ gỗ và hoa văn vải; có cả ở " +
                    "những cấu kiện tàu thuyền, cho đến những miếng ván trang trí cũng chạm khắc hình rồng. " +
                    "Nói cho đúng, rồng không được người An Nam cúng bái, nhưng chúng lại được cho có " +
                    "một quyền năng siêu nhiên: vừa là long vương vừa là chúa tể trên đất liền, mang lại hạnh " +
                    "phúc cho người sống và sự an lành cho người chết. Trong vô thức người An Nam hẳn " +
                    "xem con rồng như vị thần bảo trợ nên hình ảnh rồng có mặt khắp nơi.")
        )
        group5.items.add(
            ("Theo truyền thuyết Trung Hoa rồng “có sừng hươu, đầu lạc đà, mắt quỷ, cổ rắn, bụng cá " +
                    "sấu, vảy cá, móng vuốt chim ưng, lỗ tai bò, sừng chính là cơ quan để nó nghe”. Hình rồng " +
                    "của nghệ sĩ An Nam có nhiều điểm khác nằm ở: sừng, đôi mắt sáng rực, vảy phủ toàn " +
                    "thân, bờm tua tủa, móng sắc, đuôi soắn ốc (hình CXIX, CXXI, …).")
        )
        group5.items.add(Picture(R.drawable.p119, "Hình 119"))
        group5.items.add(Picture(R.drawable.p120, "Hình 120"))
        group5.items.add(Picture(R.drawable.p121, "Hình 121"))
        group5.items.add(
            ("Như tôi đã nói rồng là biểu tượng của hoàng đế, ai cũng rõ trong trường hợp này rồng có " +
                    "năm móng. Di vậy khi thấy trên đồ gỗ, rương hòm , gốm sứ, … có rồng năm móng tức là " +
                    "những món đồ ít nhiều trực tiếp do vua dùng (hình CXXIII, CXXVII, …). Còn dành cho " +
                    "những hạng người khác rồng chỉ có bốn móng.")
        )
        group5.items.add(Picture(R.drawable.p122, "Hình 122"))
        group5.items.add(Picture(R.drawable.p123, "Hình 123"))
        group5.items.add(Picture(R.drawable.p124, "Hình 124"))
        group5.items.add(Picture(R.drawable.p125, "Hình 125"))
        group5.items.add(Picture(R.drawable.p126, "Hình 126"))
        group5.items.add(Picture(R.drawable.p127, "Hình 127"))
        group5.items.add(
            ("Rồng còn là biểu tượng cho người chồng, vị hôn phu, và thường hơn dùng để chỉ người " +
                    "đàn ông. Phụ nữ được biểu tượng bằng con phụng. Các bài ca dao hay dùng cáchình " +
                    "tượng này để ám chỉ nam giới và phụ nữ; và khi thấy trên tấm biển, tấm thêu có hình con " +
                    "rồng và con phụng thì đó là hôn nhân mà người ta muốn ám chỉ. Thường nghĩa bóng của " +
                    "thể hiện này là chữ ‘hỉ’dính đôi (song hỉ), có nghĩa là chung vui, hạnh phúc lứa đôi.")
        )
        group5.items.add(Picture(R.drawable.p128, "Hình 128"))
        group5.items.add(Picture(R.drawable.p129, "Hình 129"))
        group5.items.add(Picture(R.drawable.p130, "Hình 130"))
        group5.items.add(Picture(R.drawable.p131, "Hình 131"))
        group5.items.add(Picture(R.drawable.p132, "Hình 132"))
        group5.items.add(
            ("Rồng được thể hiện bằng nhiều cách khác nhau. Khi thì là hình nguyên con rồng nhìn " +
                    "ngang như trên gờ nóc mái nhà, lan can cầu thang, trên vải thêu, trên bức chạm hay bức " +
                    "họa, nói tóm lại trên rất nhiều món (hình CXXIII, CXXV, …) ; khi thì chỉ thấy nguyên mặt nhìn chính diện với đầu và hai chân giạng ra gọi là ‘tàng long’ (rồng trong hang ổ) " +
                    "như ở mặt cổng lớn vườn hoa, đền miếu, dinh thự, …(hình CXXXV). Cũng có khi với " +
                    "đầu rồng và hai cân giạng lại gọi là ‘mặt rồng’ hay ‘mặt nả’ (hình CXXXVI, " +
                    "CXXXVII, …), thường thấy ở đầu hồi tam giác ở chùa chiềng và dinh phủ của người An " +
                    "Nam và để đối với hình con dơi trên trán bia, ở mặt trước khung chân tủ, … Hình đầu " +
                    "rồng chính diện ở trán có chữ vương (vua) như là vết nhăn trên mặt. Cũng có khi đó là " +
                    "chữ ‘thọ’ cách điệu, trường hợp này thường nằm trong nửa hình chữ nhật có góc dưới bẽ " +
                    "quặp xuống, viền vài đường kỷ hà (hình CXXXVIII). Người An Nam gọi hình này là " +
                    "‘rồng ăn chữ thọ’, một dấu hiệu điềm lành và cũng là sự cầu mong trường thọ.")
        )
        group5.items.add(Picture(R.drawable.p133, "Hình 133"))
        group5.items.add(Picture(R.drawable.p134, "Hình 134"))
        group5.items.add(Picture(R.drawable.p135, "Hình 135"))
        group5.items.add(Picture(R.drawable.p136, "Hình 136"))
        group5.items.add(Picture(R.drawable.p137, "Hình 137"))
        group5.items.add(
            ("Trên gờ nóc mái, rồng được thể hiện dạng kỷ hà hai con (song long) ở hai đầu gờ. Ở giữa " +
                    "gờ nóc người ta để hỏa châu đề hi con rồng chầu vào. Toàn bộ hình hai con rồng và hỏa " +
                    "châu gọi là ‘lưỡng long triều nguyệt’ (hình CXXIX, CL). Hình tượng trên gờ nóc này thể hiện một sức mạnh thần bí, sự cầu mong có mưa vì hỏa châu tượng trưng cho sấm sét còn " +
                    "hai con rồng là long vương làm mưa.")
        )
        group5.items.add(
            ("Một thể hiện gần gủi với nó là ‘lưỡng long tranh châu’ theo cách gọi của người An Nam. " +
                    "Rất thường hai chủ đề này được trộn lẫn vào nhau, hoặc là theo thiết kế của người nghệ sĩ " +
                    "hoặc là theo lý giải của dân gian. Ở chủ đề sau làm ra vẽ đánh nhau hơn là đánh nhau " +
                    "giành quả châu; và quả châu này không có các ngọn lửa bao quanh (so sánh hai hình " +
                    "CXXI và CXXXIII).")
        )
        group5.items.add(Picture(R.drawable.p139, "Hình 139"))
        group5.items.add(Picture(R.drawable.p140, "Hình 140"))
        group5.items.add(Picture(R.drawable.p141, "Hình 141"))
        group5.items.add(
            ("Nếu có điều kiện, dù trong chủ đề nào con rồng cũng có mây bao quanh, mây có dạng trãi " +
                    "ra như dãi lụa hay cuộn lại trang nhã (hình CXXI, CXXV, …) Ẩn trong mây hay kết hợp " +
                    "với mây có những sợi lửa rời rạc (hình CXIX). Cũng thường thấy rồng cỡi trên sóng " +
                    "nước ngoài biển (hình CXLIII). Nhưng sóng, sợi lửa và mây luôn được cách điệu.")
        )
        group5.items.add(
            ("Trang trí mây cũng cho ra một thể hiện đặc biệt gọi là ‘long ẩn vân’ (rồng ẩn trong mây); " +
                    "rồng uốn khúc trong các guột mây và lần lượt lộ ra từng phần con rồng. Nhiều chén gốm " +
                    "đời Thiệu Trị có mô-típ này.")
        )
        group5.items.add(
            ("Rồng kết hợp với cá cho ra ‘ngư long hí thủy’ nghĩa là rồng và cá đùa nước (hình " +
                    "CXXIX). Con cá ghếch mõm đón luồng nước từ miệng con rồng ẩn trong mây phun ra. " +
                    "Theo dân gian An Nam con cá đó là con cá chép.")
        )
        group5.items.add(
            "Không phải chỉ có một con vật duy nhất gọi là rồng. Ngoài con rồng đúng nghĩa còn thấy " +
                    "có con giao và con cù."
        )
        group5.items.add(
            ("Theo từ điển của P. Couvreur con giao hay giao long là ‘rồng không sừng’ mang dáng " +
                    "dấp con rắn, cái cổ nhỏ nhắn, bốn chân và râu trắng ở dưới cổ. Còn theo Eitel, con giao là " +
                    "‘rồng uốn gập, có bốn chân’, theo Giles là là ‘rồng có vảy’; cuối cùng theo Génibrel là " +
                    "‘con cá sấu’.")
        )
        group5.items.add(Picture(R.drawable.p142, "Hình 142"))
        group5.items.add(
            ("Con cù hay cù long cũng mơ hồ không kém. Couvreur thì nói đó là ‘con rồng có sừng’, " +
                    "nhiều người lại nói là ‘rồng không sừng’. Với Eitel là ‘rồng non có sừng’, Giles cho dó là " +
                    "‘rồng vàng’, Génibrel thì là ‘con rồng, con quái vật thần thoại, chẳng ai bảo nó có sừng’. " +
                    "Paulus Của: ‘Loài rồng không có sừng, dân gian cho rằng nó sống dưới đất và khi trồi lên " +
                    "xẻ đất tạo thành sông’.")
        )
        group5.items.add(
            ("Các nghệ sĩ An Nam thì xác định một điều: cả giao lẫn cù đều không có sừng. Chúng " +
                    "cũng không có bờm, cũng chẳng có râu như P. Couvreur nói. Tôi cũng cho rằng chúng " +
                    "không có vảy. Vậy có chân không? Điều này còn nghi ngờ vì theo tôi biết giao và cù " +
                    "không bao giờ được thể hiện nguyên hình dạng, lại luôn luôn biến cách; người ta chỉ thấy " +
                    "được đầu và cổ của chúng thôi. Dù thế nào đi nữa giao và cù được xếp vào loại rồng cấp " +
                    "thấp. Một viên quan đại thần nói với tôi về món đồ gỗ lâu đời trong nhà ông ta là nó thể " +
                    "hiện hình con giao chứ không phải con rồng thông thường vì dân gian nhiều lúc không " +
                    "dám thể hiện hình con rồng đích thực.")
        )
        group5.items.add(
            ("Tuy nhiên phải thừa nhận người ta hay pha trộn con rồng thông thường với con giao " +
                    "trong họa tiết mỹ thuật. Nhìn vào một bức chạm, người An Nam, thậm chí đó là nhà điêu " +
                    "khắc, có người bảo đó là con rồng và có người bảo đó là con giao. Do vậy tôi chỉ dùng " +
                    "chữ rồng để chỉ một hình ảnh dù đó là rồng hay giao. Tuy nhiên có lúc tôi dịch chữ giao " +
                    "là rồng-rắn (serpent-dragon).")
        )
        group5.items.add(Picture(R.drawable.p143, "Hình 143"))
        group5.items.add(Picture(R.drawable.p144, "Hình 144"))
        group5.items.add(Picture(R.drawable.p145, "Hình 145"))
        group5.items.add(Picture(R.drawable.p146, "Hình 146"))
        group5.items.add(Picture(R.drawable.p147, "Hình 147"))
        group5.items.add(Picture(R.drawable.p148, "Hình 148"))
        group5.items.add(Picture(R.drawable.p149, "Hình 149"))
        group5.items.add(Picture(R.drawable.p150, "Hình 150"))
        group5.items.add(Picture(R.drawable.p151, "Hình 151"))
        group5.items.add(
            ("Đối với con cù, nó có nét chuyên biệt, nếu không ở hình dáng hay và thuộc tính thì cũng " +
                    "ở cách dùng và vị trí người ta đặt nó: tay tỳ của ngai đá để ngoài trời dành cho một số nữ " +
                    "thần có trang trí đầu cù long. Chi tiết sườn nhà bên ngoài nối cột và bên trong nối lỗ đòn " +
                    "tay gọi là ‘xà cù’ có thể lấy tên từ con cù, đuôi chi tiết này đôi khi trang trí hình đầu con " +
                    "rồng.")
        )
        group5.items.add(
            ("Rồng nguyên con, hoặc là rồng đích thực hay con giao, thường là hồi văn hóa long (hình " +
                    "XXIII, XXV, ..); lá và dây lá là lá hóa long (hình CXI và các hình kế tiếp); hóa long thấy " +
                    "ở mây và trúc (hình CLII, CLIII) và một số loài cây khác như: tùng, mẫu đơn, cúc, loa " +
                    "kèn8, … (hình CLV)")
        )
        group5.items.add(
            ("Rồng chính diện biến cách gọi là ‘mặt nả’. Người ta hay giải thích mặt nả có nghĩa là mặt " +
                    "rồng., tôi chẳng rõ chữ ‘nả’ nghĩa là gì. Họa tiết tạo mặt rồng nhìn chính diện có nhiều " +
                    "thứ khác nhau tùy theo từng nghệ sĩ. Có khi là lá lật, có khi là hoa mẫu đơn, lại có khi là " +
                    "bông tây, lá hay dây lá (hình CXXXVII). Người ta cũng dung quả phật thủ và hoa sen " +
                    "biến cách thành đầu rồng nhìn chính diện (hình CIX, CIII, CIV). Chùm và tràng hoa biến " +
                    "cách thành họa tiết giao-hoa (hoa hóa giao)")
        )
        group5.items.add(Picture(R.drawable.p152, "Hình 152"))
        group5.items.add(Picture(R.drawable.p153, "Hình 153"))
        group5.items.add(Picture(R.drawable.p154, "Hình 154"))
        val listLesson5: MutableList<Group?> = ArrayList<Group?>()
        listLesson5.add(group5)
        lesson5.groups = listLesson5
        lessons.add(lesson5)
        val lesson6 = Lesson("Bài 6: Họa tiết hình thú – con lân", R.drawable.p155)
        val group6 = Group("")
        group6.items.add(
            ("Khi người An Nam nói đến kỳ lân thì họ nghĩ đó là một từ duy nhất, nhưng theo các từ " +
                    "điển của Trung Hoa thì đấy là một từ kép: con kỳ và con lân, kỳ là con đực và lân là con " +
                    "cái. Do vậy, khi một người An Nam chỉ cho bạn xem hình vẽ trên bình phong hay bức " +
                    "chạm trên trụ đá và nói đó là kỳ lân, bạn nên hiểu đó là con kỳ hay con lân, tức con đực " +
                    "hay con cái.")
        )
        group6.items.add(
            ("Từ điển của Gibrel ghi: Kỳ lân, “licorne, sphinx” (ngựa một sừng, nhân sư) và chua thêm: " +
                    "“loài chim thần thoại” (oiseau fabuleux). Đó là vi ông muốn diễn tả con đực là kỳ và con " +
                    "cái là lân, điều đó quả chính xác là vậy.")
        )
        group6.items.add(
            ("Từ điển của Paulus Của nói cần phận biệt rõ kỳ là con đực và lân là con cái, Nhưng ông " +
                    "lưu ý là hai từ này luôn dùng đi đôi với nhau chứ không tách ra, Dựa vào thư tịch Trung " +
                    "Hoa ông giải thích đó là con vật giống sư tử, có một sừng ở giữa trán và là một trong tứ " +
                    "linh. Đứng về mặt phong tục, kỳ lân là con vật có lòng nhân, tốt bụng; nó chẳng bao giờ dẫm lên cỏ non, chẳng làm hại ai cả; chỉ những vì thánh vương 10 mới được gặp nó. Vì có " +
                    "tính nhân hậu như vậy nên có thành ngữ ‘lân giác’ tức sừng con lân cái, nghĩa là thứ vũ " +
                    "khí vô hại.")
        )
        group6.items.add(
            ("Từ điển tiếng Hoa của Giles, Eitel, Couvreur cho những thông tin sau: Kỳ lân là con vật " +
                    "thần thoại thiêng liêng, có mình nai, đuôi bò, một sừng, phủ vảy cá, … Chiếc sừng này " +
                    "bằng thịt hàm chỉ tính nhân hậu của con thú này; dù có khả năng chiến đấu và chiến " +
                    "thắng nhưng kỳ lân rất chuộng hòa bình. Tuy nhiên có điểm bất đồng về chiếc sừng này, " +
                    "Eitel và Couvreur đều cho rằng kỳ là con đực không có sừng hay một loài thú nào đó " +
                    "giống con lân mà thôi.")
        )
        group6.items.add(
            ("Chi tiết này dù thế nào đi nữa thì kỳ lân có tính nhân hậu như trong truyền thuyết: con vật " +
                    "này chẳng bao giờ đi trên sinh vật sống và chẳng bao giờ ăn cỏ tươi; sừng của nó là biểu " +
                    "tượng cho lòng yêu hòa bình.")
        )
        group6.items.add(
            ("“Dấu chân của Kỳ lân” dùng chỉ nòi giống vua chúa, và “lân giác” chỉ hoàng thái tử. " +
                    "Trên kiệu cưới người ta hay ghi dòng chữ “Kỳ lân tại thử” (麒麟在此) có nghĩa “kỳ lân ở " +
                    "nơi này 12 ”; và câu “Gót kỳ lân mang lại may mắn” là lời chúc dành cho trẻ em.")
        )
        group6.items.add(
            ("Còn đây là lời chú thêm của P. Corentin Pétillon 13 : Sự xuất hiện của kỳ lân báo hiệu sự ra " +
                    "đời của thánh vương và luôn luôn là điềm lành. Kỳ lân có dáng vẽ: mình hươu, đuôi bò, " +
                    "đầu sói có một sừng với đầu sừng là núm thịt, móng ngựa. Người ta gọi kỳ lân là nhân " +
                    "thú là vì nó có bản năng tự nhiên khi bước đi cẩn thậm không đạp chết côn trùng hay " +
                    "giẫm lên cây cỏ còn sống dù là vật bé nhỏ nhất. Khó mà đào hầm giăng lưới bắt được kỳ " +
                    "lân vì nó hết sức khôn ngoan tránh được mọi thứ bẫy. Vậy mà kinh thư lại nói chuyện bắt " +
                    "được kỳ lân khiến Khổng Tử ngậm ngùi rơi lệ.")
        )
        group6.items.add(
            ("Khổng Tử rơi lệ là vì khi ngài đản sinh có con kỳ lân xuất hiện mang đến nhà ngài tấm " +
                    "thẻ ngọc có ghi câu: “Đứa trẻ khôn ngoan này sẽ là vị vua không ngai vào thời nhà Chu " +
                    "suy tàn”. Mẹ Khổng Tử bắt lấy kỳ lân và dùng vải lụa cột lại; nhưng hôm sau con vật " +
                    "biến mất. Mãi lâu sau có người thợ săn bắt được kỳ lân mang dãi lụa, Khổng Tử nhận ra " +
                    "đó là con kỳ lân lúc ngài đản sinh. Ngài cầm lấy dãi lụa đầm đìa nước mắt vì biết khi kỳ " +
                    "lân xuất hiện lần thứ hai ngài sắp không còn tại thế nữa.")
        )
        group6.items.add(
            ("Như tôi đã nói người An Nam quen gọi lân hay kỳ lân, nhưng cũng có khi lại gọi là long " +
                    "mã, nghĩa là con vật vừa có tính chất rồng vừa có tính chất ngựa, thể hiện trên các bình " +
                    "phong. Truyền thống Trung Hoa thì phân biệt rõ long mã với kỳ lân, người An Nam thì " +
                    "không vậy.")
        )
        group6.items.add(
            (" Kỳ lân được dùng làm họa tiết trang trí trên các bình phong trong các đền chùa (hình " +
                    "CLV; CLVI, CLVII). Dối với người An Nam khi thì là kỳ lân, khi thì là long mã. Nó " +
                    "luôn mang trên lưng cổ đồ (bức đồ xưa); người An Nam dù là dân giả, nho gia, thợ nề " +
                    "hay nhà điêu khắc đều gọi đó là “cổ đồ”. Chữ cổ đồ Hán Việt này trùng âm với chữ Nôm " +
                    "nên dễ nhầm. Tôi thích hình cổ đồ của vua Phục Hi trên lưng con kỳ lân hơn trên lưng " +
                    "long mã của Trung Hoa. Theo truyền thuyết vị hoàng đế thần thoại này xem bức cổ đồ " +
                    "này mà nghĩ ra âm-dương, từ âm dương chồng lên nhau lập thành bát quái, rồi 64 quẻ.")
        )
        group6.items.add(
            "Hình vua thấy đầu tiên đó họi là Hà Đồ (bứcvẽ trên sông Hoàng Hà). Một truyền thuyết " +
                    "khác về bát quái nói vua Hoàng Đế lấy từ lưng con rùa."
        )
        group6.items.add(
            ("Dù gì trên các bức bình phong hình con lân thỉnh thoảng có mang trên lưng bánh xe tám " +
                    "cạnh của bát quái. Trong trường hợp này ẩn dụ về vua Phục Hy rõ ràng rồi. Còn với bức " +
                    "đồ cổ thì được thể hiện bằng bó sách hay bằng hai phiến chữ, hoặc cuộn giấy; đôi lúc " +
                    "mấy thứ trên còn được gắn thêm cây bút lông hay cây quạt, hoặc thanh gươm. Chẳng biết " +
                    "như thế là do ngẫu hứng của tác giả hay do không biết mà vẽ như vậy (hình CLV). Tôi " +
                    "chẳng hiểu vì sau mấy món đó lại được diễn giải thành ‘cổ đồ’như đã nói ở trên. Tuy " +
                    "nhiên món chính lai liên quan đến việc viết lách, đến khoa học: cuốn sách, phiến chữ, " +
                    "cuộn giấy, cây bút. Chúng có thể diễn giải thành ‘cổ đồ’ của vua Phục Hy và với ‘bát " +
                    "quái’ . Đó là kinh dịch, cuốn sách kỳ bí làm nền tảng cho thuật bói toán, cho môn biến " +
                    "hóa của muôn vật.")
        )
        group6.items.add(Picture(R.drawable.p155, "Hình 155"))
        group6.items.add(Picture(R.drawable.p156, "Hình 156"))
        group6.items.add(Picture(R.drawable.p157, "Hình 157"))
        group6.items.add(Picture(R.drawable.p158, "Hình 1548"))
        group6.items.add(Picture(R.drawable.p159, "Hình 159"))
        group6.items.add(
            ("Cổ đồ luôn luôn trang trí thêm dãi lụa, đặt trên tấm thảm rồi mới để lên lưng kỳ lân. Sau " +
                    "này chúng ta lại thấy dãi lụa xuất hiện ở lưng con rùa hay mỏ con hạc. Với con rồng " +
                    "không có dãi lụa. Tuy nhiên ttrên các phiến đồ gỗ chúng ta thấy có con vật biến cách một " +
                    "cách mơ hồ, trông giống con rồng hơn là kỳ lân, cũng mang cổ đồ trên lưng. Tôi cho rằng " +
                    "cáu đó do thiếu hiểu biết hay nhầm lẫn của người nghệ sĩ mà ra.")
        )
        group6.items.add(
            ("Đôi khi chúng ta cũng thấy kỳ lân được dùng như loại trang trí dấu nhấn, nhưng lúc này " +
                    "phụ vào con rồng hay con phụng. Bấy giồ lân được xuất hiện ở đầu rìa với tư thế không " +
                    "phóng khoáng cho lắm (hình CLVIII).")
        )
        group6.items.add(Picture(R.drawable.p160, "Hình 160"))
        group6.items.add(Picture(R.drawable.p161, "Hình 161"))
        group6.items.add(
            ("Một con vật rất giống nhưng không phải là kỳ lân, đó là con sư tử, nhưng cũng được " +
                    "ngườiAn Nam coi trọng xếp ngang với lân tạc trên các đỉnh trụ đá ở các đên chùa. Bộ " +
                    "lông, đầu, đuôi, móng vuốt (chứ không phải móng đề) quả là sư tử hơn là kỳ lân. Tuy vậy " +
                    "tôi vẫn xếp nó vào nhóm kỳ lân theo như tín ngưỡng của người An Nam (hình CLVI, " +
                    "CLVIII) Đó là vì trên các món đồ trang trí nhỏ bằng đồng hay đồng thau, trên các bộ lư " +
                    "người An Nam gọi con vật trang trí trên đó, trông giống con sư tử thì đúng hơn, là con " +
                    "lân. Ở các bộ lư con lân có công dụng là núm nắp. Người An Nam khi thì gọi nó là lân " +
                    "khi lại gọi là sư (hình CLVIII). Hình như trong hệ động vật trang trí của người An Nam " +
                    "thiếu sự chính xác tên gọi hay sao đó, ở các con vật khác chúng ta sắp nói đền vậy.")
        )
        group6.items.add(
            ("Còn trong biến cách, kỳ lân thường được hóa ra từ nhánh mẫu đơn gọi là mẫu đơn hóa " +
                    "lân. Nhưng cũng thấy có quả lê hóa lân và tôi từng thấy tại một số đền chùa nhiều loại " +
                    "cây trái dùng trong trang trí cổ điển cũng được biến cách thành lân.")
        )
        group6.items.add(Picture(R.drawable.p162, "Hình 162"))
        group6.items.add(Picture(R.drawable.p163, "Hình 163"))
        val listLesson6: MutableList<Group?> = ArrayList<Group?>()
        listLesson6.add(group6)
        lesson6.groups = listLesson6
        lessons.add(lesson6)
        val lesson7 = Lesson("Bài 7: Họa tiết hình thú – con phụng", R.drawable.p164)
        val group7 = Group("")
        group7.items.add(
            ("Hình CLXIV cho một ý tưởng về các phẩm chất của một con chim phụng, bức hình này " +
                    "được thể hiện ít nhiều hoàn hảo trên tấm bình phong của các ngôi đền 15 thờ nữ thần: đúng " +
                    "theo mô tả của P. Corentin Pétillon “mỏ gà, cổ rắn, trán én, lưng rùa và đuôi cá”. Hình " +
                    "phụng được thể hiện trên sóng cồn ngoài biển, nhưng là một trong tứ linh nên phụng có " +
                    "quyền năng siêu nhiên cỡi trên sóng biển. Ở đây nói qua về truyền thuyết nói về sức " +
                    "mạnh chim phụng: “Tung cánh bay lên từ phương đông, vượt khỏi ngọn núi Côn Lôn, ghé " +
                    "uống nước nơi thác Đế Trụ, rũ cánh tắm ở biển Nhược Thủy, cuối cùng nghỉ cánh ở núi " +
                    "Đơn Huyệt.” Một lần tung cánh của chim phụng xa ngần ấy.")
        )
        group7.items.add(
            ("Cánh nó vươn rộng với những cọng lông cứng mà người ta nói cúng như thép, lông đuôi " +
                    "rực rỡ như ngọn lửa, đôi chân vững trãi; đó là biểu tượng cho thao lược và nhân hậu, kiêu " +
                    "hãnh và tôn quý. Phụng ngậm một dãi lụa khi thì treo vào đó cuộn giấy, khi thì là cái hộp " +
                    "vuông hay thẻ bài; theo một số người đó là ‘cổ đồ’ huyền thoại của vua Phục Hi nhưng " +
                    "có người lại bảo đó là kinh thư thánh hiền; hình tượng này có tên “Phụng hàm thư” (hình " +
                    "CXIV và các hình kế tiếp). Tôi chẳng rõ ai nói đúng.")
        )
        group7.items.add(Picture(R.drawable.p164, "Hình 164"))
        group7.items.add(Picture(R.drawable.p165, "Hình 165"))
        group7.items.add(Picture(R.drawable.p166, "Hình 166"))
        group7.items.add(Picture(R.drawable.p167, "Hình 167"))
        group7.items.add(
            ("Theo truyền thuyết Trung Hoa, chim phụng có nhiều phẩm hạnh cao đẹp: “tiếng hót ngân " +
                    "khắp ngũ âm, lông trang điểm ngũ sắc, thân thể biểu tượng cho sáu thứ: đầu tượng trời, " +
                    "mắt tượng thái dương (mặt trời), lưng tượng thái âm (mặt trăng), cánh tượng gió, chân " +
                    "tượng đất và đuôi tượng tinh tú.” Các vẽ đẹp và phẩm hạnh đó xứng là vua các loài chim, " +
                    "nó thường đậu trên cây ngô đồng. Chim phụng chỉ xuất hiện vào thời thái bình và ẩn " +
                    "mình khi thời loạn lạc. Nên phụng là biểu tượng cho thái bình.")
        )
        group7.items.add(
            ("mình khi thời loạn lạc. Nên phụng là biểu tượng cho thái bình. " +
                    "Những tín ngưỡng đó xa lạ đối với người An Nam; họ chỉ biết duy nhất một điều: chim " +
                    "phụng là biểu tượng cho sự kết hợp giữa người nam và người nữ, tức hôn nhân. Chuyện " +
                    "kể có hai người nam và người nữ xinh đẹp tuyệt trần, tâm đầu ý hợp với nha; người nam " +
                    "là một vị tiên và người nữ vốn là phụng. Vị tiên từ trời bay xuống hòa duyên cùng phụng. " +
                    "Hay là tích long phụng hòa duyên 16 ; trong bức vẽ long là người chồng và phụng là người " +
                    "vợ. Hình vẽ con rồng và con phụng vờn quanh chữ song hỉ, cũng là biểu tượng của hôn " +
                    "nhân, của hạnh phúc lứa đôi.")
        )
        group7.items.add(
            ("Hình ảnh chim phụng dành chỉ người phụ nữ. Chính vì vậy phụng thường trang trí ở các " +
                    "gờ mái những đền thờ nữ thần, và nơi này các bình phong cũng chạm vẽ hình chim phụng " +
                    "thay vì con rồng. Hình phụng cũng thấy trang trí trên trán bia hay viền khung bia mộ của các công chúa, rồi lại thấy ở giường chạm hay hộp đựng ấn của nữ giới (hình CLXVI, " +
                    "CLXVII, CLXVIII). Nhưng cũng chẳng gì ngăn cấm được người nghệ sĩ dùng mô-típ " +
                    "này trang trí đồ gỗ hay dinh thự bình thường như hình trang trí phụ. Nhìn chung khi thấy " +
                    "chim phụng dùng làm họa tiết chính trên đồ vật thì biết đó là món dành cho phụ nữ.")
        )
        group7.items.add(
            ("Loài chim này có hai tên gọi: con trống gọi là phụng và con mái gọi là hoàng; gộp lại gọi " +
                    "là phụng hoàng. Nhưng thông thường người An Nam gọi gọn là phụng mà thôi. Chim " +
                    "mái còn có tên khác ‘loan’ 17 , nên gọi là phụng loan. Theo truyền thuyết Trung Hoa và " +
                    "người An Nam đón nhận, tiếng kêu của loài chim này biểu lộ sự ứng họa của cặp tình " +
                    "nhân, của hạnh phúc lứa đôi; cho nên hình ảnh chim phụng vừa là lời cầu chúc vừa nói " +
                    "lên sự gắn bó vợ chồng.")
        )
        group7.items.add(Picture(R.drawable.p168, "Hình 168"))
        group7.items.add(Picture(R.drawable.p169, "Hình 169"))
        group7.items.add(Picture(R.drawable.p170, "Hình 170"))
        group7.items.add(Picture(R.drawable.p171, "Hình 171"))
        group7.items.add(
            ("Còn về tổng quan chom phụng là biểu tượng thái bình như đã nói ở trên. Nên trong cung " +
                    "điện cũng có hình chim phụng để phỉnh nịnh ca tụng vua chúa đang sống thời thái bình " +
                    "thịnh trị vì có chim phụng xuất thế.")
        )
        group7.items.add(
            ("Như tôi đã trình bày, trong kiến trúc hình ảnh chim phụng được dùng làm trang trí dấu " +
                    "nhấn trên các gờ mái đền thờ nữ thần. Nhưng cũng thấy ở các đền khác và trong cung " +
                    "điện nhưng chỉ là thứ yếu và nhường vị trí chính yếu cho con rồng, phụng chỉ thấy ở đầu " +
                    "hồi. Hoe61m hơn, phụng được thay thế cho vị trí của con dơi (hình CLIX). Ở lăng mộ " +
                    "các công chúa thay vì con rồng người ta dùng hình phụng để trang trí trán bia hay viền " +
                    "quanh bia. Cuối cùng còn thấy vẽ hay chạm trên các tấm chi tiết đồ gỗ, trên nắp hộp, trên " +
                    "bình phong lụa, trên thành bộ ván (hình CLXXII); cũng như làm trang trí dấu nhấn ở đèn, " +
                    "giá đỡ chậu, … (hình CLXXI).")
        )
        group7.items.add(
            ("Phụng còn có những biến cách (hóa), thường nhất là đào hóa phụng, nhưng cũng thấy " +
                    "hoa mẫu đơn hóa phụng (hình CLXXII). Hoặc nhánh cúc hay quả na, hoa lan (hình " +
                    "CLXXIII) kết hợp với họa tiết phụng. Hình phụng ít dùng vì khó dát hơn rồng, khó ngang " +
                    "với hình lân, dù rằng tính mảnh dẻ và nét trang trọng hết sức thích hợp.")
        )
        group7.items.add(
            ("Ở Bắc Kỳ, trước các ngôi đền thường thấy bốn chim phụng không đuôi trên các đỉnh cột. " +
                    "Rất mỹ thuật, nhưng tôi chẳng biết nó mang ý nghĩa gì đối với người An Nam. Với công dụng trang trí tương tự, dĩ nhiên í trang trọng và nhẹ nhàng hơn, người ta dùng họa tiết " +
                    "cụm lá ô-rô thay vào (hình CXVII, CXVIII).")
        )
        group7.items.add(
            ("Có một con chim tương tự khác gọi là hạc. Lưu ý là hình dáng hạc với phụng, cũng như " +
                    "tính biểu tượng, khác xa nhau. Hạc luôn có đôi cánh xếp lại và tạc đứng (thường đứng " +
                    "trên con rùa) dùng làm món đồ thờ. Miệng hạc ngậm một cánh hoa, thường là một đôi " +
                    "trước bàn thờ thần hay bàn thờ tổ tiên. Hạc không thấy dùng làm họa tiết trang trí.")
        )
        group7.items.add(
            ("Hình như theo người Trung Hoa có hạc đen, hạc vàng và hạc xanh nữa, nhưng người An " +
                    "Nam chỉ dùng hạc trắng và màu lông trắng đó tượng trưng cho tuối thọ. Người Trung " +
                    "Hoa cũng như người An Nam đều tin chim hạc có tuổi thọ cao, người Trung Hoa cho " +
                    "rằng khi đến 160 tuổi lông hạc biến thành màu đen, lúc đó gọi là huyền hạc. Để chỉ người " +
                    "già người ta hay dùng thành ngữ “da mồi tóc hạc”, nghĩa là tóc bạc trắng như lông hạc và " +
                    "da nhăn nheo như vảy đồi mồi.")
        )
        group7.items.add(
            ("Thêm nữa, hạc là vật cưỡi của chư tiên, đuều này được đánh đồng là chúng trường sinh " +
                    "bất tử? Vì thế hạc còn có tên “tiên điểu” (chim của tiên) Ở Trung Hoa người ta làm đồ " +
                    "vàng mã có những con hạc giấy để đốt cúng, với lời cầu mong người chết cỡi nó bay lên " +
                    "trời. Rùa là một biểu tượng khác của sự trường thọ nên thường đi đôi với hạc (hình " +
                    "CLXXIV). Chim hạc không có biến cách từ họa tiết khác, nhưng ở Trung Hoa hạc đôi " +
                    "khi được nhân cách hóa thành Thọ Tinh và đi chung với chữ thọ.")
        )
        group7.items.add(Picture(R.drawable.p172, "Hình 172"))
        group7.items.add(Picture(R.drawable.p173, "Hình 173"))
        group7.items.add(Picture(R.drawable.p174, "Hình 174"))
        group7.items.add(Picture(R.drawable.p175, "Hình 175"))
        val listLesson7: MutableList<Group?> = ArrayList<Group?>()
        listLesson7.add(group7)
        lesson7.groups = listLesson7
        lessons.add(lesson7)
        val lesson8 = Lesson("Bài 8: Họa tiết hình thú – con rùa", R.drawable.p176)
        val group8 = Group("")
        group8.items.add(
            ("Rùa, tiếng Hán Việt là quy (龜), là một trong tứ linh, biểu tượng cho sự trường thọ vì nó " +
                    "sống trên ngàn tuổi. Triều đại nhà Đường có một quan tổng đốc các tỉnh phía nam dâng " +
                    "lên hoàng đế Hiến Tông (806-821) một con rùa có lông cho đó là điềm lành trường sinh, " +
                    "chẳng qua mai của nó bám rong và rêu mà ra.")
        )
        group8.items.add(
            ("Vì mai rùa ở trên tròn nên được coi là tượng của trời, ở dưới dẹt tượng của đất, nên rùa ví " +
                    "như sống lâu như trời đất. Từ xưa, người ta dùng mai rùa bỏ vào than hồng đốt để bói " +
                    "toán: nghe tiếng nổ lách tách mà đoán chuyện vị lai. Đời vua Hoàng Đế 18 có một con rùa " +
                    "thần (thần quy) nổi trên sông Lạc có những vằn kỳ bí, vua theo đó mà viết ra Kinh dịch, " +
                    "chuyện giống như vua Phục Hy lấy được vằn trên lưng con Long mã.")
        )
        group8.items.add(
            ("Ở Trung Hoa người ta tin rằng rùa cái thường giao phối với con rắn, nên thường cho đó " +
                    "là biểu tượng của sự bất trinh. Khi vẽ hình con rùa vào cột nhà ai là có ý bảo người đó " +
                    "kém phẩm hạnh. Vẽ hình ảnh đó, hay đơn giản viết chữ quy thôi, ở nơi ngõ cụt hay góc " +
                    "phố có nghĩa là ngỏ lời mời khách qua đường ghé lại làm chuyện trăng hoa.")
        )
        group8.items.add(
            "Vì rùa có dáng nặng nề nên được cho là biểu tượng của sự vững trãi nên ở Trung Hoa rùa " +
                    "được thờ làm thần hộ đê."
        )
        group8.items.add(
            ("Người An Nam hình như không quan tâm những biểu tượng đó, rùa được dùng làm đế " +
                    "bia với tín ngưỡng tin vào sự trường thọ, cũng như tin vào sự vững bền như biểu hiện " +
                    "nặng nề nơi cơ thể nó (hình CLXXVII).")
        )
        group8.items.add(Picture(R.drawable.p176, "Hình 176"))
        group8.items.add(Picture(R.drawable.p177, "Hình 177"))
        group8.items.add(
            ("Người ta cũng thấy rùa làm trang trí dấu nhấn ở gờ bên mái nhà, nhưng trường hợp này " +
                    "hiếm thấy (hình CLVII, CLVIII). Khi nó mang trên lưng cổ đồ, tức bộ sách có buộc dãi " +
                    "lụa, thì nó là thần quy mang Lạc Thư, miệng nó sẽ phun ra cuộn sóng gọi là thủy ba. " +
                    "Sen hóa rùa (liên hóa quy) là hình tượng: lá sen có mép cong vằn lên thành mai con rùa " +
                    "(hình CLXXIX) thường trang trí giữa đám sen. Cũng theo ngẫu hứng một số nghệ sĩ, các " +
                    "loài quả lá khác cũng biến cách thành rùa.")
        )
        group8.items.add(Picture(R.drawable.p178, "Hình 178"))
        group8.items.add(Picture(R.drawable.p179, "Hình 179"))
        val listLesson8: MutableList<Group?> = ArrayList<Group?>()
        listLesson8.add(group8)
        lesson8.groups = listLesson8
        lessons.add(lesson8)
        val lesson9 = Lesson("Bài 9: Họa tiết hình thú – con dơi", R.drawable.p192)
        val group9 = Group("")
        group9.items.add(
            ("Dơi có vai trò lớn trong nghệ thuật trang trí An Nam, nó biểu tượg cho chữ ‘phúc’. Là do " +
                    "tiếng Hán Việt dơi là chữ ‘bức’ (蝠) đọc gần giống chữ ‘phúc’ (福), từ đó người ta dùng " +
                    "hình ảnh con vật này để chỉ ‘phúc đức’. Khi minh họa bằng hình 5 con dơi là hàm ý chỉ " +
                    "ngũ phúc: (1) Phú 富 nghĩa là giàu, (2) khang ninh 安寧 là yên lành, mạnh khỏe (3) Thọ " +
                    "壽 là sống lâu (4) hảo đức 好德 là có đức tốt (5) khảo chung mạng 考終命 là hưởng trọn " +
                    "tuổi trời (hình CLXXX).")
        )
        group9.items.add(Picture(R.drawable.p180, "Hình 180"))
        group9.items.add(Picture(R.drawable.p181, "Hình 181"))
        group9.items.add(Picture(R.drawable.p182, "Hình 182"))
        group9.items.add(Picture(R.drawable.p183, "Hình 183"))
        group9.items.add(Picture(R.drawable.p184, "Hình 184"))
        group9.items.add(Picture(R.drawable.p185, "Hình 185"))
        group9.items.add(
            ("Cùng với hình ảnh con dơi các họa tiết thường có lối chơi chữ. Thường nhất là lối chơi " +
                    "chữ ghép với chữ ‘phúc’ nhưng cũng có khi đi với chữ ‘khánh’ (慶 có nghĩa là ‘chúc " +
                    "mừng’) thay cho lời cầu chúc phúc. Khánh lại có thêm âm là ‘khương’ có nghĩa là phúc. " +
                    "Âm khánh lại có chữ viết là 磬, chỉ một món nhạc khí quý trong cung đình, thế là có họa " +
                    "tiết con dơi ngậm chiếc khánh có hai quả tua; hình này có tên ‘phúc khánh’ với ý chúc " +
                    "mừng hưởng phúc an lạc và thịnh vượng (hình CLXXXVI, CLXXXIX, CXC).")
        )
        group9.items.add(Picture(R.drawable.p186, "Hình 186"))
        group9.items.add(Picture(R.drawable.p187, "Hình 187"))
        group9.items.add(Picture(R.drawable.p188, "Hình 188"))
        group9.items.add(Picture(R.drawable.p189, "Hình 189"))
        group9.items.add(Picture(R.drawable.p190, "Hình 190"))
        group9.items.add(
            ("Hoặc cũng có khi đi với chữ ‘thọ’, thành ra ‘phúc thọ’, tức cầu chúc vừa hưởng phúc vừa " +
                    "đắc thọ. Trong mô-típ trang trí thành ngữ này được thể hiện bằng hình con dơi ngậm chữ " +
                    "thọ cách điệu. Nhiều lúc chữ thọ được thu gọn thành hình bát giác đơn giản với chiếc lá " +
                    "vươn dài ra và co rúm, biến cách thành con dơi (hình CXCI, CXCII).")
        )
        group9.items.add(
            ("Thay cho khánh ngọc hay chữ thọ, con thấy hình con dơi ngậm một giõ hoa. Giõ hoa là " +
                    "một món trong ‘bát bửu’ nên hàm chỉ sự vui hưởng hạnh phúc (hình CLXXXIV). " +
                    "Về mặt trang trí con dơi hay có kèm theo hai quả tua, gọi là họa tiết ‘dơi tua’, nhưng hình " +
                    "như hai quả tua đó chẳng mang một ý nghĩa sâu xa nào ngoài sự trang trí. (hình " +
                    "CLXXXI, …)")
        )
        group9.items.add(
            ("Dơi có thể được biến cách từ lá, họi là lá hóa phúc, từ hoa mai gọi là mai hóa phúc, từ " +
                    "sen gọi là liên hóa phúc, từ quả gọi là quả hóa phúc; nhưng chủ yếu là từ hình hồi văn có " +
                    "tô điểm thêm hia lá gọi là hồi văn hóa phúc. Tùy theo ngẫu hứng người nghệ sĩ còn cho " +
                    "con dơi đi chung với rồng. Một vài chỗ thấy dơi xuất hiện ngay giữa tấm chi tiết của đồ " +
                    "gỗ, nhưng thường thì nằm ở các góc và giang cánh rất trang nhã. Trên đồ kim hoàn con " +
                    "dơi hay hóa thành những hạt tòn ten ở bông tai.")
        )
        group9.items.add(Picture(R.drawable.p191, "Hình 191"))
        group9.items.add(Picture(R.drawable.p192, "Hình 192"))
        group9.items.add(Picture(R.drawable.p193, "Hình 193"))
        val listLesson9: MutableList<Group?> = ArrayList<Group?>()
        listLesson9.add(group9)
        lesson9.groups = listLesson9
        lessons.add(lesson9)
        val lesson10 = Lesson("Bài 10: Họa tiết hình thú – sư tử", R.drawable.p197)
        val group10 = Group("")
        group10.items.add(
            ("Trong mỹ thuật An Nam sư tử có hai tên: sư và nghê. Đầu tiên nói đến con sư tử có bờm " +
                    "xoắn, lông uốn lượn, đuôi tỏa cuộn, vuốt cứng; nhưng dáng vẽ hiền lành. Con vật này " +
                    "luôn được thể hiện với một trái cầu có dãi lụa dài xé tơi hay gút lại một cách mỹ thuật. Dĩ " +
                    "nhiên toàn bộ chủ đề này chỉ là ước lệ, nhất là bộ lông.")
        )
        group10.items.add(
            ("Mô-típ này thường dùng trang trí các góc: con sư tử có dáng như bước xuống thềm cửa, " +
                    "hai chân trước chạm vào ngạch tam cấp nối liền với khung cửa. Trong trường hợp này chỉ " +
                    "thấy có một con sư tử cùng với quả cầu gọi là sư tử hí cầu.")
        )
        group10.items.add(
            ("Đôi lúc thấy trên bình phong có trang trí hình 5 con sư tử gọi là ngũ sư hí cầu (hình " +
                    "CXCV), hoặc thấy chỉ một hay nhiều con sư tử ở trên nắp bình vôi hay lư hương (hình " +
                    "CXCVI). Thế nhưng gặp khi không có quả cầu thì người An Nam kẻ thì bảo đó là con lân, " +
                    "người thì nói là sư tử. Quả có nhiều mơ hồ trong tên gọi hình thú của An Nam.")
        )
        group10.items.add(
            ("Hình thái khác của con sư tử là con nghê hay toan nghê 22 (hình CXCVII). Cả từ điển " +
                    "Trung Hoa lẫn An Nam đều định nghĩa nghê là ‘sư tử nhanh’ (lion rapide), ‘ngựa hoang’ " +
                    "hay ‘sư tử Tây Tạng’, luôn mơ hồ. Nhưng hình dáng nói chung có khác biệt với sư tử ở " +
                    "phần đầu, móng vuiốt, lông và mõm có nanh nhọn cong vui61t; tức thiên về nét con " +
                    "hoẵng và con ngựa hơn. Theo truyền thuyết con nghê mỗi ngày đi được 500 dặm hay mỗi " +
                    "cú nhảy của nó xa 500 dặm; nó vồ cả cọp để ăn.")
        )
        group10.items.add(
            ("Con nghê được trang trí ở Điện Thái Hòa, hai con đặt hai bên điện. Con vật này bằng " +
                    "đồng thau, đặt trong chiếc tủ bằng thủy tinh kê cao 1 thước và có đầy đủ dáng vẽ con " +
                    "nghê. Trước nhà bia lăng Thiệu Trị cũng có hai con nghê bằng đồng đỏ, kích thước cũng " +
                    "cỡ đó. (hình CXCVII)")
        )
        group10.items.add(Picture(R.drawable.p194, "Hình 194"))
        group10.items.add(Picture(R.drawable.p195, "Hình 195"))
        group10.items.add(Picture(R.drawable.p196, "Hình 196"))
        group10.items.add(Picture(R.drawable.p197, "Hình 197"))
        val listLesson10: MutableList<Group?> = ArrayList<Group?>()
        listLesson10.add(group10)
        lesson10.groups = listLesson10
        lessons.add(lesson10)
        val lesson11 = Lesson("Bài 11: Họa tiết hình thú – con cọp", R.drawable.p198)
        val group11 = Group("")
        group11.items.add("Tác giả không có bài viết, chỉ minh họa một số hình.")
        group11.items.add(Picture(R.drawable.p198, "Hình 198"))
        group11.items.add(Picture(R.drawable.p199, "Hình 199"))
        val listLesson11: MutableList<Group?> = ArrayList<Group?>()
        listLesson11.add(group11)
        lesson11.groups = listLesson11
        lessons.add(lesson11)
        val lesson12 = Lesson("Bài 12: Họa tiết hình thú – con cá", R.drawable.p202)
        val group12 = Group("")
        group12.items.add(
            ("Ở Trung Hoa, chữ ngư 漁 (con cá) phát âm giống chữ dư 輿 (dư thừa). Do vậy hình ảnh " +
                    "con cá biểu tượng cho sự trù phú, thường vẽ thành hình một đứa bé cầm con cá với nghĩa " +
                    "“Phú, hữu dư” (giàu, có dư).")
        )
        group12.items.add(
            ("Ở An Nam không thể có lối chơi chữ này vì chữ “cá” và chữ “dư” không trùng âm. " +
                    "Nhưng có thể do ảnh hưởng Trung Hoa mà vào lễ tết Trung thu người Hà Nội hay mua " +
                    "con cá làm bằng giấy dầu cho trẻ em chơi. Tập tục này không thấy ở Huế và vùng phụ " +
                    "cận, nhưng vào ngày đầu năm người ta lại hay mua hình con cá làm bằng giấy màu treo ở " +
                    "trước bàn thờ tổ tiên gay đâu đó trong nhà để cầu may.")
        )
        group12.items.add(
            ("Ở Bắc Kỳ trong các đền chùa thảy đều thấy hình con cá ở các gờ mái như loại trang trí " +
                    "dấu nhấn. Tôi nghe nói rằng đó là biểu tượng “cá hóa rồng”, đuôi của cá được cách điệu " +
                    "hình cuộn thanh thoát và trang nhã. Ở Huế hiếm thấy họa tiết này ở đền chùa, chỉ thấy ở " +
                    "dinh phủ: khi thì nguyên hình con cá thật tự nhiên (hình CCIV), khi thì được cách điệu " +
                    "giống như ở Bắc Kỳ (hình CCV). Có một số món bằng gốm tráng men có vẽ hình cá hình " +
                    "như từ Trung Hoa mang sang (hình CCIII).")
        )
        group12.items.add(Picture(R.drawable.p200, "Hình 200"))
        group12.items.add(Picture(R.drawable.p201, "Hình 201"))
        group12.items.add(Picture(R.drawable.p202, "Hình 202"))
        group12.items.add(
            ("Con cá làm thành hình miệng máng xối có nét tự nhiên vì được hiểu nước là một yếu tố " +
                    "sống còn của cá (hình CCII). Trang trí ở giá đỡ chậu rữa mặt cũng theo nghĩa này (hình " +
                    "CCI), nhưng truyền thống An Nam thích chạm hình đầu phụng hay rồng mềm mại và tinh " +
                    "tế hơn.")
        )
        group12.items.add(
            ("Cá ngoài biểu tượng cho sự giàu sang như đã nói, nó còn là biểu tượng cho sự đăng khoa " +
                    "của nho sĩ: cá hóa rồng. Đó là tích Long Môn Điểm Ngạch 龍門點額 của Trung Hoa, " +
                    "nghĩa là chúc thi đậu. Con cá đó người An Nam gọi là con cá gáy 24 , nó vượt long môn " +
                    "thành rồng. Chính vì vậy ở mặt tiền Quốc Tử Giám Huế có khắc hình tượng con cá đang " +
                    "hóa thành rồng.")
        )
        group12.items.add(Picture(R.drawable.p203, "Hình 203"))
        group12.items.add(Picture(R.drawable.p204, "Hình 204"))
        group12.items.add(Picture(R.drawable.p205, "Hình 205"))
        val listLesson12: MutableList<Group?> = ArrayList<Group?>()
        listLesson12.add(group12)
        lesson12.groups = listLesson12
        lessons.add(lesson12)
        initRecyclerView()
    }
    
    private fun initRecyclerView() {
        val staggeredRVAdapter = StaggeredRVAdapter(lessons, this)
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL)
        binding.recyclerView.layoutManager = staggeredGridLayoutManager
        binding.recyclerView.adapter = staggeredRVAdapter
    }
    
    private fun showDialog(fragment: DialogFragment) {
        val fm: FragmentManager? = fragmentManager
        fragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_AppCompat_Light_NoActionBar)
        fragment.show(fm!!, "")
    }
    
    override fun onLessionClick(lesson: Lesson?) {
        showDialog(LessonDetail(lesson!!))
    }
    
    
}