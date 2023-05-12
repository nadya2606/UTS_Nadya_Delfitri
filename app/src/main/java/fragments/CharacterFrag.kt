package fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uts_botnavrecview.*


class CharacterFrag : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var charArrayList: ArrayList<Characters>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvChar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharactersAdapter(charArrayList){
        val intent = Intent(context,DetailCharacterActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        charArrayList = arrayListOf<Characters>()

        image = arrayOf(
            R.drawable.alamanda,
            R.drawable.anggrek,
            R.drawable.kamboja,
            R.drawable.kembangsepatu,
            R.drawable.lily,
            R.drawable.matahari,
            R.drawable.mawar,
            R.drawable.melati,
            R.drawable.rosemary,
            R.drawable.tulip,
        )

        title = arrayOf(
            getString(R.string.Alamanda),
            getString(R.string.Anggrek),
            getString(R.string.Kamboja),
            getString(R.string.KembangSepatu),
            getString(R.string.Lily),
            getString(R.string.Matahari),
            getString(R.string.Mawar),
            getString(R.string.Melati),
            getString(R.string.Rosemary),
            getString(R.string.Tulip),

        )
        description = arrayOf(
            getString(R.string.desc_alamanda),
            getString(R.string.desc_anggrek),
            getString(R.string.desc_kamboja),
            getString(R.string.desc_kembangsepatu),
            getString(R.string.desc_lily),
            getString(R.string.desc_matahari),
            getString(R.string.desc_mawar),
            getString(R.string.desc_melati),
            getString(R.string.desc_rosemary),
            getString(R.string.desc_tulip),
        )

        for (i in image.indices) {
            val char = Characters(image[i], title[i], description[i])
            charArrayList.add(char)
        }

    }
}
