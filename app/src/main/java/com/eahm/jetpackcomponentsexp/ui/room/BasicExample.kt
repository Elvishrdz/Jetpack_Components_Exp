package com.eahm.jetpackcomponentsexp.ui.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eahm.jetpackcomponentsexp.R
import com.eahm.jetpackcomponentsexp.adapters.ProductAdapter
import com.eahm.jetpackcomponentsexp.interfaces.IProductOptions
import com.eahm.jetpackcomponentsexp.models.Product
import com.eahm.jetpackcomponentsexp.viewmodel.BasicExampleViewModel
import kotlinx.android.synthetic.main.activity_basic_example.*

class BasicExample : AppCompatActivity(), IProductOptions {

    /* To obtain the viewModels() add to build.gradle
    1. implementation "androidx.activity:activity-ktx:1.1.0"
    2. kotlinOptions {
         jvmTarget = JavaVersion.VERSION_1_8.toString()
       }
    */

    private val viewModel: BasicExampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_example)

        /**
         * Steps
         * 1. Add the dependency and the annotation processor of room to build.gradle
         *
         * 2. Create a model for the table (See Product.kt)
         *  2.1 Convert the model to an entity using the @Entity annotation.
         *   2.1.1 Assign a name to the table with (tableName = 'name_here')
         *  2.2 Add the proper annotations to each property in the model @ColumnInfo, @PrimaryKey, etc.
         *
         * 3. Create the Data Access Object DAO (See ProductDao.kt)
         *  3.1 This is an interface with the annotation @Dao
         *  3.2 Here you can create all the methods to operate through the table
         *   3.2.1 You can use @Insert @Query to specify the operation in the table.
         *    3.2.1.1 The @Query uses the Structured Query Language SQL
         *    3.2.1.2 To use a parameter of the method as a variable in the query use double
         *            colons = :variable :name :id
         *
         * 4. Add the Room Database (See ProductDatabase.kt)
         *  4.1 This is an abstract class which extends RoomDatabase()
         *   4.1.1 Convert the class to a database using the @Database annotation.
         *    4.1.1.1 Assign the entities and a version number with (entities = [(Entity1::class), (Entity2::class)], version = 1)
         *    4.1.1.2 Check (and Learn) the instantiation of the
         *            database (See getDatabase(context:Context):ProductDatabase?{} method in ProductDatabase.kt)
         *
         * 5. Add the repository (See ProductRepository.kt)
         *  5.1 Create all the asyncTask operations for each operation defined in ProductDao.kt
         *  5.2 Obtain the DAO reference from the database instance
         *  5.3 Provide public methods to execute the async operations
         *  5.4 Add a liveData to observe changes in all the "products" table and initialize it with the DAO reference (See init{} in ProductRepository.kt)
         *
         *  6. Preparing the ViewModel (or the consumer) (See BasicExampleViewModel.kt)
         *   6.1 ViewModel does not accept parameters by default, But there's a class that extends the same
         *       functionality but providing a unique parameter no other than an Application object: AndroidViewModel(application:Application)
         *   6.2 Initialize the repository and obtain the reference of the public LiveData objects to provide the UI.
         *   6.3 Create public methods and (now) provide to the UI
         *
         *  7. You're done! or almost.
         *
         *  Now you can connect the viewModel with your view and perform operations to the database!
         *
         */

        //region setting the recycler view
        val productAdapter = ProductAdapter(this)
        rvProducts.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
        //endregion setting the recycler view

        viewModel.getAllProducts()?.observe(this, Observer {
            if(it != null) productAdapter.setProductList(it.asReversed())
        })

        setListeners()
    }

    private fun setListeners() {
        btnProductAdd.setOnClickListener{
            val name = etProductName.text.toString()

            if(name.isNotEmpty()){
                viewModel.insertProduct(
                    Product(name = name)
                )
            }
            else {
                Toast.makeText(this, getString(R.string.product_name_empty), Toast.LENGTH_SHORT).show()
            }
        }

        btnProductDelete.setOnClickListener{
            val name = etProductName.text.toString()

            if(name.isNotEmpty()){
               deleteProduct(name)
            }
            else {
                Toast.makeText(this, getString(R.string.product_name_empty), Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun deleteProduct(productName : String) {
        viewModel.deleteProduct(productName)
    }
}