// Connect to the restaurants database
conn = new Mongo();
db = conn.getDB("restaurants");

// Set a reference to all documents in the restaurants collection
cursor = db.restaurants.find({}, {
	"_id": 0,
	"address.zipcode": 1,
	"borough": 1,
	"name": 1,
	"restaurant_id": 1
});

// Iterate the cursor and output each document
while (cursor.hasNext()) {
	printjson(cursor.next());
}