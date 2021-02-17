// Connect to the restaurants database
conn = new Mongo();
db = conn.getDB("restaurants");

// Set a reference to specific documents in the restaurants collection
cursor = db.restaurants.find({
	"name": {
		$regex: "^Mad"
	}
}, {
	"address.coord": 1,
	"borough": 1,
	"cuisine": 1,
	"name": 1
});

// Iterate the cursor and output each document
while (cursor.hasNext()) {
	printjson(cursor.next());
}