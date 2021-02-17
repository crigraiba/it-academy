// Connect to the restaurants database
conn = new Mongo();
db = conn.getDB("restaurants");

// Set a reference to specific documents in the restaurants collection
cursor = db.restaurants.find({
	"address.coord": {
		$lt: -65.754168
	},
	"cuisine": {
		$ne: "American "
	},
	"grades.score": {
		$gt: 70
	}
});

// Iterate the cursor and output each document
while (cursor.hasNext()) {
	printjson(cursor.next());
}