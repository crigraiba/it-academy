// Connect to the restaurants database
conn = new Mongo();
db = conn.getDB("restaurants");

// Count the number of documents in the restaurants collection referenced by a cursor
res = db.restaurants.find({
	"address.street": {
		$exists: false
	}
}).count();

// Output the result
print(res);