package bad.robot.blinkstick;

import java.security.SecureRandom;

public enum Color {

	Aqua("#00ffff"),
	AliceBlue("#f0f8ff"),
	AntiqueWhite("#faebd7"),
	Black("#000000"),
	Blue("#0000ff"),
	Cyan("#00ffff"),
	DarkBlue("#00008b"),
	DarkCyan("#008b8b"),
	DarkGreen("#006400"),
	DarkTurquoise("#00ced1"),
	DeepskyBlue("#00bfff"),
	Green("#008000"),
	Lime("#00ff00"),
	MediumBlue("#0000cd"),
	MediumSpringGreen("#00fa9a"),
	Navy("#000080"),
	SpringGreen("#00ff7f"),
	Teal("#008080"),
	MidnightBlue("#191970"),
	DodgerBlue("#1e90ff"),
	LightSeaGreen("#20b2aa"),
	ForestGreen("#228b22"),
	SeaGreen("#2e8b57"),
	DarkSlateGrey("#2f4f4f"),
	LimeGreen("#32cd32"),
	MediumseaGreen("#3cb371"),
	Turquoise("#40e0d0"),
	RoyalBlue("#4169e1"),
	SteelBlue("#4682b4"),
	DarkslateBlue("#483d8b"),
	MediumTurquoise("#48d1cc"),
	Indigo("#4b0082"),
	DarkoliveGreen("#556b2f"),
	CadetBlue("#5f9ea0"),
	CornflowerBlue("#6495ed"),
	MediumAquamarine("#66cdaa"),
	DimGrey("#696969"),
	SlateBlue("#6a5acd"),
	Olivedrab("#6b8e23"),
	SlateGret("#708090"),
	SlateGrey("#708090"),
	LightSlateGret("#778899"),
	LightslateGrey("#778899"),
	MediumslateBlue("#7b68ee"),
	LawnGreen("#7cfc00"),
	Aquamarine("#7fffd4"),
	Chartreuse("#7fff00"),
	Grey("#808080"),
	Maroon("#800000"),
	Olive("#808000"),
	Purple("#800080"),
	LightskyBlue("#87cefa"),
	SkyBlue("#87ceeb"),
	BlueViloet("#8a2be2"),
	Darkmagenta("#8b008b"),
	DarkRed("#8b0000"),
	Saddlebrown("#8b4513"),
	DarkseaGreen("#8fbc8f"),
	LightGreen("#90ee90"),
	Mediumpurple("#9370db"),
	DarkViloet("#9400d3"),
	PaleGreen("#98fb98"),
	Darkorchid("#9932cc"),
	YellowGreen("#9acd32"),
	Sienna("#a0522d"),
	Brown("#a52a2a"),
	DarkGrey("#a9a9a9"),
	Greenyellow("#adff2f"),
	LightBlue("#add8e6"),
	PaleTurquoise("#afeeee"),
	LightsteelBlue("#b0c4de"),
	PowderBlue("#b0e0e6"),
	Firebrick("#b22222"),
	Darkgoldenrod("#b8860b"),
	Mediumorchid("#ba55d3"),
	Rosybrown("#bc8f8f"),
	Darkkhaki("#bdb76b"),
	Silver("#c0c0c0"),
	MediumViloetRed("#c71585"),
	IndianRed("#cd5c5c"),
	Peru("#cd853f"),
	Chocolate("#d2691e"),
	Tan("#d2b48c"),
	LightGrey("#d3d3d3"),
	Thistle("#d8bfd8"),
	Goldenrod("#daa520"),
	Orchid("#da70d6"),
	PaleViloetRed("#db7093"),
	Crimson("#dc143c"),
	Gainsboro("#dcdcdc"),
	Plum("#dda0dd"),
	Burlywood("#deb887"),
	LightCyan("#e0ffff"),
	Lavender("#e6e6fa"),
	Darksalmon("#e9967a"),
	Palegoldenrod("#eee8aa"),
	Viloet("#ee82ee"),
	Azure("#f0ffff"),
	Honeydew("#f0fff0"),
	Khaki("#f0e68c"),
	Lightcoral("#f08080"),
	Sandybrown("#f4a460"),
	Beige("#f5f5dc"),
	Mintcream("#f5fffa"),
	Wheat("#f5deb3"),
	Whitesmoke("#f5f5f5"),
	GhostWhite("#f8f8ff"),
	Lightgoldenrodyellow("#fafad2"),
	Linen("#faf0e6"),
	Salmon("#fa8072"),
	Oldlace("#fdf5e6"),
	Bisque("#ffe4c4"),
	Blanchedalmond("#ffebcd"),
	Coral("#ff7f50"),
	Cornsilk("#fff8dc"),
	Darkorange("#ff8c00"),
	Deeppink("#ff1493"),
	FloralWhite("#fffaf0"),
	Fuchsia("#ff00ff"),
	Gold("#ffd700"),
	Hotpink("#ff69b4"),
	Ivory("#fffff0"),
	Lavenderblush("#fff0f5"),
	Lemonchiffon("#fffacd"),
	Lightpink("#ffb6c1"),
	Lightsalmon("#ffa07a"),
	Lightyellow("#ffffe0"),
	Magenta("#ff00ff"),
	Mistyrose("#ffe4e1"),
	Moccasin("#ffe4b5"),
	NavajoWhite("#ffdead"),
	Orange("#ffa500"),
	OrangeRed("#ff4500"),
	Papayawhip("#ffefd5"),
	PeachPuff("#ffdab9"),
	Pink("#ffc0cb"),
	Red("#ff0000"),
	Seashell("#fff5ee"),
	Snow("#fffafa"),
	Tomato("#ff6347"),
	White("#ffffff"),
	Yellow("#ffff00");

	private static final SecureRandom random = new SecureRandom();

	private final String hex;

	Color(String hex) {
		this.hex = hex;
	}

	public int rgb() {
		int red = Integer.valueOf(hex.substring(1, 3), 16);
		int green = Integer.valueOf(hex.substring(3, 5), 16);
		int blue = Integer.valueOf(hex.substring(5, 7), 16);

		return 255 << 24 | red << 16 | green << 8 | blue;
	}

	public int getRed() {
		return (rgb() >> 16) & 0xFF;
	}

	public int getGreen() {
		return (rgb() >> 8) & 0xFF;
	}

	public int getBlue() {
		return rgb() & 0xFF;
	}

	public static Color random() {
		Color[] values = Color.values();
		return values[random.nextInt(values.length)];
	}

}
