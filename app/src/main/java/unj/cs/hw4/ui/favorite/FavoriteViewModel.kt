package unj.cs.hw4.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import unj.cs.hw4.data.Datasource
import unj.cs.hw4.model.Coffee

class FavoriteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    val myDataset: List<Coffee> = Datasource().loadCoffee().filter { it.favorite }
}