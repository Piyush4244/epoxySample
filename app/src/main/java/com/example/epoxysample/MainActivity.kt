package com.example.epoxysample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.carousel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv=findViewById<EpoxyRecyclerView>(R.id.rvTask)
        rv.withModels {
            title {
                id("title")
                title("Need Assistant")
            }

            val carouselItemModels = carouselItems.map { currentItem ->
                TaskCarouselBindingModel_()
                    .id(currentItem.id)
                    .carouselItem(currentItem)
                    .clickListener { v ->

                    }

            }

            // Carousel
            // This extension function come with epoxy
            carousel {
                id("car")
                models(carouselItemModels)
            }

            title {
                id("title-id")
                title("Need Assistant")
            }

            tasks.forEach{curr->
                task {
                    id(curr.id)
                    task(curr)
                }
            }
        }
    }
}

val tasks = listOf(
    Task("id1", "Audio & Video", 4),
    Task("id2", "Updating", 6),
    Task("id3", "Drink and food", 2),
    Task("id4", "Security", 4),
    Task("id5", "Dark theme     ", 6),
    Task("id6", "Dark theme     ", 6),
    Task("id7", "Dark theme     ", 6),
    Task("id8", "Dark theme     ", 6),
    Task("id9", "Dark theme     ", 6)
)

val carouselItems = listOf(
    CarouselItem("id11", "Event problems", "Call issue center"),
    CarouselItem("id21", "Emergency", "Call policy"),
    CarouselItem("id31", "Tassk 4", "Call google"),
    CarouselItem("id41", "Tassk 4", "Call google"),
    CarouselItem("id51", "Tassk 4", "Call google"),
    CarouselItem("id61", "Tassk 4", "Call google"),
    CarouselItem("id71", "Tassk 4", "Call google")
)

data class Task(
    val id: String,
    val title: String,
    val peopleCount: Int
)

data class CarouselItem(
    val id: String,
    val title: String,
    val description: String
)