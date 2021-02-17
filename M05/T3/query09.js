// Connect to the restaurants database
conn = new Mongo();
db = conn.getDB("restaurants");

// Set a reference to specific documents in the restaurants collection
cursor = db.restaurants.find({
	"grades": {
		$elemMatch: {
			"score": {
				$gt: 80,
				$lt: 100
			}
		}
	}
});

// Iterate the cursor and output each document
while (cursor.hasNext()) {
	printjson(cursor.next());
}