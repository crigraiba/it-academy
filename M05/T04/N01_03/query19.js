// Connect to the restaurants database
conn = new Mongo();
db = conn.getDB("restaurants");

// Set a reference to specific documents in the restaurants collection
cursor = db.restaurants.find({
	"borough": {
		$nin: [
			"Staten Island",
			"Queens",
			"Bronx",
			"Brooklyn"
		]
	}
}, {
	"borough": 1,
	"cuisine": 1,
	"name": 1,
	"restaurant_id": 1
});

// Iterate the cursor and output each document
while (cursor.hasNext()) {
	printjson(cursor.next());
}