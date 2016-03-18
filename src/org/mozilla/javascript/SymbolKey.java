package org.mozilla.javascript;

/**
 * A SymbolKey is one of the implementations of Symbol. It is really there
 * so that we can easily use pre-defined symbols as keys in native code.
 * A SymbolKey has the special property that two NativeSymbol objects
 * with the same key are equal.
 */

public class SymbolKey
    implements Symbol
{
    // These are common SymbolKeys that are equivalent to well-known symbols
    // defined in ECMAScript.
    public static final SymbolKey ITERATOR = new SymbolKey("iterator");
    public static final SymbolKey TO_STRING_TAG = new SymbolKey("toStringTag");
    public static final SymbolKey SPECIES = new SymbolKey("species");
    public static final SymbolKey HAS_INSTANCE = new SymbolKey("hasInstance");
    public static final SymbolKey IS_CONCAT_SPREADABLE = new SymbolKey("isConcatSpreadable");
    public static final SymbolKey TO_PRIMITIVE = new SymbolKey("toPrimitive");
    public static final SymbolKey MATCH = new SymbolKey("match");
    public static final SymbolKey REPLACE = new SymbolKey("replace");
    public static final SymbolKey SEARCH = new SymbolKey("search");
    public static final SymbolKey SPLIT = new SymbolKey("split");
    public static final SymbolKey UNSCOPABLES = new SymbolKey("unscopables");

    private String name;

    public SymbolKey(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode()
    {
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof SymbolKey) {
            return o == this;
        }
        if (o instanceof NativeSymbol) {
            return ((NativeSymbol) o).getKey() == this;
        }
        return false;
    }

    @Override
    public String toString()
    {
        if (name == null) {
            return "Symbol()";
        }
        return "Symbol(" + name + ')';
    }
}
