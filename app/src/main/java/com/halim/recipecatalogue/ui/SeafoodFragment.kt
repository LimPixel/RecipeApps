package com.halim.recipecatalogue.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.halim.recipecatalogue.R
import com.halim.recipecatalogue.adapter.RecipesAdapter
import com.halim.recipecatalogue.data.DataRecipes
import com.halim.recipecatalogue.data.Recipes
import com.halim.recipecatalogue.databinding.FragmentSeafoodBinding

class SeafoodFragment : Fragment() {

    private var _binding: FragmentSeafoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentSeafoodBinding.inflate(inflater, container, false)
        initData()
        return binding.root
    }

    private fun initData() {
        resources.apply {
            val name = getStringArray(R.array.name_seafood)
            val category = getStringArray(R.array.category_seafood)
            val description = getStringArray(R.array.description_seafood)
            val ingredients = getStringArray(R.array.ingredients_seafood)
            val instructions = getStringArray(R.array.instructions_seafood)
            val photo = getStringArray(R.array.photo_seafood)
            val price = getStringArray(R.array.price_seafood)
            val calories = getStringArray(R.array.calories_seafood)
            val carbo = getStringArray(R.array.carbo_seafood)
            val protein = getStringArray(R.array.protein_seafood)

            for (data in protein.indices){
                val seafood = Recipes(
                    name[data],
                    category[data],
                    description[data],
                    ingredients[data],
                    instructions[data],
                    photo[data],
                    price[data],
                    calories[data],
                    carbo[data],
                    protein[data],
                )
            }

        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSeafood.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = RecipesAdapter(DataRecipes.listBreakfast)
        }
    }
}