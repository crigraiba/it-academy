// Connect to the restaurants database
conn = new Mongo();
db = conn.getDB("restaurants");

// Set a reference to specific documents in the restaurants collection
cursor = db.restaurants.find({
	"grades.1": {
		"date": ISODate("2014-08-11T00:00:00Z"),
		"grade": "A",
		"score": 9
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