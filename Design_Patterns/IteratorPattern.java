/**
	Question: Iterator Design Pattern

	Reference: 	http://www.journaldev.com/1716/iterator-design-pattern-in-java-example-tutorial
				http://www.tutorialspoint.com/design_pattern/iterator_pattern.htm

	Definition: 
		This pattern is used to get a way to access the elements of a collection object in sequential manner without any need to know its underlying representation.
	
	Example: If you get an Array, ArrayList, and HashTable of Objects you pop out an iterator for each and treat them the same. This provides a uniform way to cycle through different collections. 

	Implmentation: 
		- 
*/

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {
	public static void main(String[] args) {
		ChannelCollection collections = populateChannels();
		ChannelIterator iterator_all = collections.iterator(ChannelTypeEnum.ALL);
		while(iterator_all.hasNext()) {
			Channel c = iterator_all.next();
			System.out.println(c);
		}
		
		System.out.println("*************************************************");
		ChannelIterator iterator_telugu = collections.iterator(ChannelTypeEnum.TELUGU);
		while(iterator_telugu.hasNext()) {
			Channel c = iterator_telugu.next();
			System.out.println(c);
		}
	}
	
	private static ChannelCollection populateChannels() {
		ChannelCollection channels = new ChannelCollectionImpl();
        channels.addChannel(new Channel(98.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(99.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(100.5, ChannelTypeEnum.TELUGU));
        channels.addChannel(new Channel(101.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(102.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(103.5, ChannelTypeEnum.TELUGU));
        channels.addChannel(new Channel(104.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(105.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(106.5, ChannelTypeEnum.TELUGU));
        return channels;
	}
}

// ChannelTypeEnum will give us all the available channels.
enum ChannelTypeEnum {
	ENGLISH, HINDI, TELUGU, ALL;
}

// What does a Channel have? Frequency and Channel.
class Channel {
	private double frequency;
	private ChannelTypeEnum TYPE;
	
	public Channel(double frequency, ChannelTypeEnum type) {
		this.frequency = frequency;
		this.TYPE = type;
	}
	
	public double getFrequency() {
		return frequency;
	}
	public ChannelTypeEnum getTYPE() {
		return TYPE;
	}
	
	@Override
	public String toString() {
		return "Frequency = " + frequency + "\t Type = " + TYPE;
	}
}

interface ChannelCollection {
	public void addChannel(Channel c);
	public void removeChannel(Channel c);
	public ChannelIterator iterator(ChannelTypeEnum type);
}

interface ChannelIterator {
	public boolean hasNext();
	public Channel next();
}

class ChannelCollectionImpl implements ChannelCollection {

	List<Channel> channelList;
	
	public ChannelCollectionImpl() {
		channelList = new ArrayList<Channel>();
	}
	
	@Override
	public void addChannel(Channel c) {
		channelList.add(c);
	}

	@Override
	public void removeChannel(Channel c) {
		channelList.remove(c);
	}

	@Override
	public ChannelIterator iterator(ChannelTypeEnum type) {
		return new ChannelIteratorImpl(type, channelList);
	}
	
	private class ChannelIteratorImpl implements ChannelIterator {

		private ChannelTypeEnum type;
		private List<Channel> channelList;
		private int position;
		
		public ChannelIteratorImpl(ChannelTypeEnum type, List<Channel> channelsList) {
			this.type = type;
			this.channelList = channelsList;
		}
		
		@Override
		public boolean hasNext() {
			while(position < channelList.size()) {
				Channel c = channelList.get(position);
				if(type.equals(c.getTYPE()) || type.equals(ChannelTypeEnum.ALL)) {
					return true;
				} else {
					position++;
				}
			}
			
			return false;
		}

		@Override
		public Channel next() {
			Channel c = channelList.get(position);
			position++;
			return c;
		}
	}
}