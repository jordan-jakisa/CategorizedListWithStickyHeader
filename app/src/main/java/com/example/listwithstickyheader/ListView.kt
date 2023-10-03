package com.example.listwithstickyheader

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NamesList() {
    val categories: List<CategorizedNames> = names.groupBy { it.first() }
        .toSortedMap().map {
        CategorizedNames(
            title = it.key.toString(),
            names = it.value
        )
    }
    LazyColumn {
        categories.forEach {
            stickyHeader {
                Row(modifier = Modifier

                    .background(
                        MaterialTheme.colorScheme.primaryContainer
                    )
                    .fillMaxWidth() ) {
                    Text(
                        text = it.title, modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        )
                    )
                }

            }
            items(it.names) { name ->
                Text(
                    text = name,
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        )
                )
            }
        }
    }

}

data class CategorizedNames(
    val title: String,
    val names: List<String>
)

val names = listOf(
    "John Smith", "Mary Johnson", "David Brown", "Jennifer Davis", "William Wilson",
    "Patricia Lee", "Richard Anderson", "Linda Martinez", "Charles Taylor", "Elizabeth Hernandez",
    "Joseph Moore", "Susan Martin", "Thomas Jackson", "Margaret White", "Daniel Harris",
    "Jessica Thompson", "Robert Lewis", "Sarah Hall", "John Turner", "Nancy Walker",
    "Michael King", "Karen Adams", "James Young", "Lisa Wright", "David Scott",
    "Betty Hall", "William Rodriguez", "Dorothy Lopez", "Richard Gonzalez", "Sandra Lewis",
    "Joseph Clark", "Kimberly Baker", "Daniel Lewis", "Donna Hall", "Paul White",
    "Ruth Adams", "George Davis", "Michelle Brown", "Kenneth Martinez", "Emily Perez",
    "Edward Allen", "Carol Thomas", "Frank Wilson", "Amanda Nelson", "Larry Garcia",
    "Judith Mitchell", "Steven Turner", "Martha Smith", "Stephen Martinez", "Cynthia Adams",
    "Ronald Hall", "Anna Rodriguez", "Kenneth Hall", "Laura Gonzalez", "Brian Lee",
    "Susan Harris", "Timothy Perez", "Helen Jackson", "Kevin Miller", "Betty Wright",
    "Jeffrey Taylor", "Margaret Thomas", "Donald Hernandez", "Sandra Robinson", "Jason Davis",
    "Sharon Harris", "Christopher Johnson", "Nancy Garcia", "Paul Young", "Betty Jackson",
    "Andrew Anderson", "Kimberly Brown", "Brian Lee", "Donna Lewis", "Charles King",
    "Shirley Hall", "Mark White", "Deborah Walker", "Larry Jackson", "Betty Taylor",
    "Thomas Davis", "Mary Lee", "Gary Turner", "Nancy Clark", "Ronald Garcia",
    "Linda Wilson", "Kevin Wilson", "Susan Wright", "Mark Robinson", "Deborah Harris",
    "James Taylor", "Elizabeth Lee", "Scott Young", "Helen Hall", "Brian Clark",
    "Mary White", "Kenneth Lee", "Lisa Anderson", "David Martin", "Dorothy Lopez",
    "Jeffrey Smith", "Jennifer Scott", "Christopher King", "Linda Harris", "Donald Adams",
    "Deborah Hernandez", "George Davis", "Ruth Johnson", "Frank Jackson", "Margaret Hall",
    "Stephen Taylor", "Jessica Garcia", "Paul Anderson", "Linda Brown", "Daniel Martinez",
    "Michelle Thomas", "Michael Young", "Cynthia White", "James Anderson", "Deborah Adams",
    "William Smith", "Susan Hall", "David Davis", "Karen Walker", "Michael Harris",
    "Barbara Clark", "Christopher Thomas", "Linda Wilson", "Mark Lee", "Susan Martinez",
    "Thomas Turner", "Lisa Rodriguez", "Joseph Lewis", "Ruth Lewis", "Paul Miller",
    "Kimberly Wilson", "Larry Wilson", "Sharon Davis", "William Walker", "Shirley Robinson",
    "Gary Hernandez", "Laura Harris", "David White", "Mary Young", "William Hall",
    "Elizabeth Brown", "Mark Jackson", "Carol Lopez", "Michael Lee", "Linda Hernandez",
    "Daniel Miller", "Barbara Martin", "Michael Lewis", "Patricia Wilson", "James Turner",
    "Betty Smith", "David Davis", "Cynthia Gonzalez", "Richard Robinson", "Karen Walker",
    "Michael Thomas", "Margaret Clark", "Kenneth Harris", "Susan Lee", "Paul Harris",
    "Jennifer Martin", "Brian Allen", "Mary Jackson", "Richard Hall", "Deborah Allen",
    "Stephen White", "Jennifer Perez", "George Taylor", "Carol Young", "Edward Davis",
    "Cynthia Davis", "Mark Lee", "Nancy Perez", "Donald Young", "Michelle Lee",
    "George Smith", "Betty Robinson", "Robert Clark", "Barbara Martin", "Kenneth Taylor",
    "Sharon Garcia", "David Davis", "Mary Lee", "Larry King", "Laura Lewis",
    "Thomas Robinson", "Elizabeth Lopez", "Michael Anderson", "Jennifer Thomas", "Frank Brown",
    "Sandra Taylor", "Joseph Garcia", "Kimberly Turner", "William Smith", "Susan Smith",
    "Thomas Walker", "Karen Walker", "Robert Smith", "Margaret Wilson", "Edward Allen",
    "Jessica White", "Christopher Allen", "Nancy Wilson", "Joseph Robinson", "Sharon King",
    "Frank Taylor", "Susan Smith", "George Jackson", "Jennifer White", "Mark Clark",
    "Shirley Davis", "Donald Lee", "Mary Lee", "Edward Robinson", "Linda Smith",
    "Thomas Walker", "Laura Davis", "Joseph Lee", "Nancy Young", "William"
)
