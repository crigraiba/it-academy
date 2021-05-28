// Connect to the restaurants database
conn = new Mongo();
db = conn.getDB("restaurants");

// Set a reference to specific documents in the restaurants collection
cursor = db.restaurants.find({
	"grades.score": {
		$mod: [
			7,
			0
		]
	}
}, {
	"grades": 1,
	"name": 1,
	"restaurant_id": 1
});

// Iterate the cursor and output each document
while (cursor.hasNext()) {
	printjson(cursor.next());
}